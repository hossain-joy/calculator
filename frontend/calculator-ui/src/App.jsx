// src/App.jsx
import React, { useState, useEffect, useCallback } from 'react';
import Calculator from './components/Calculator';
import History from './components/History';

const API_URL = 'http://localhost:8080/api/calculator';

function App() {
  const [history, setHistory] = useState([]);

  // useCallback ensures this function isn't recreated on every render
  const fetchHistory = useCallback(async () => {
    try {
      const response = await fetch(`${API_URL}/history`);
      const data = await response.json();
      setHistory(data);
    } catch (error) {
      console.error("Failed to fetch history:", error);
    }
  }, []);

  // useEffect with an empty dependency array [] runs once when the component mounts
  useEffect(() => {
    fetchHistory();
  }, [fetchHistory]);

  return (
    <div className="app-container">
      <Calculator onNewCalculation={fetchHistory} />
      <History calculations={history} />
    </div>
  );
}

export default App;