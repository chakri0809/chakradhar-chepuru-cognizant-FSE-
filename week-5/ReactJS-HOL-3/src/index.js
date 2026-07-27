// this is the starting point of my react app
// ReactDOM renders my App component into the root div in index.html
import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<App />);
