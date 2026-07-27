// HOL 12 - Calling API from React
// Two ways: Fetch API and Axios
import React from 'react';
import FetchUsers from './components/FetchUsers';
import AxiosPosts from './components/AxiosPosts';

function App() {
  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h1>HOL 12 - Calling API with React</h1>
      <hr />
      <h2>Method 1: Using Fetch API</h2>
      <FetchUsers />
      <hr />
      <h2>Method 2: Using Axios</h2>
      <AxiosPosts />
    </div>
  );
}

export default App;
