// src/components/Calculator.jsx
import React, { useState } from "react";

// The API URL our backend is running on
const API_URL = "http://localhost:8080/api/calculator";

const Calculator = ({ onNewCalculation }) => {
  const [expression, setExpression] = useState("");
  const [display, setDisplay] = useState("0");

  const handleButtonClick = (value) => {
    if (value === "C") {
      setExpression("");
      setDisplay("0");
    } else if (value === "=") {
      // When equals is pressed, call the API
      calculateResult();
    } else {
      // Append the value to the expression
      const newExpression = expression + value;
      setExpression(newExpression);
      setDisplay(newExpression);
    }
  };

  const calculateResult = async () => {
    if (!expression) return;
    try {
      const response = await fetch(`${API_URL}/calculate`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ expression: expression }),
      });

      if (!response.ok) {
        throw new Error("Calculation failed");
      }

      const data = await response.json();
      setDisplay(data.result);
      setExpression(String(data.result)); // Set expression to the result for further calcs
      onNewCalculation(); // Tell the parent component to refresh history
    } catch (error) {
      setDisplay("Error");
      setExpression("");
      console.error("Error:", error);
    }
  };

  const buttons = [
  '1', '2', '3', '+',
  '4', '5', '6', '-',
  '7', '8', '9', '*',
  '0', '.', 'C', '/'
];


  return (
    <div className="calculator">
      <div className="display">{display}</div>
      <div className="keypad">
        {buttons.map((btn) => (
          <button
            key={btn}
            onClick={() => handleButtonClick(btn)}
            className={isNaN(btn) && btn !== "." ? "operator" : ""}
          >
            {btn}
          </button>
        ))}
        <button className="equals" onClick={() => handleButtonClick("=")}>
          =
        </button>
      </div>
    </div>
  );
};

export default Calculator;
