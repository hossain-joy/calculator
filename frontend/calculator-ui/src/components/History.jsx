// src/components/History.jsx
import React from 'react';

const History = ({ calculations }) => {
    return (
        <div className="history">
            <h2>Calculation History</h2>
            <ul>
                {calculations.length > 0 ? (
                    calculations.slice().reverse().map((calc) => ( // Show latest first
                        <li key={calc.id}>
                            {calc.expression} = {calc.result}
                        </li>
                    ))
                ) : (
                    <p>No history yet.</p>
                )}
            </ul>
        </div>
    );
};

export default History;