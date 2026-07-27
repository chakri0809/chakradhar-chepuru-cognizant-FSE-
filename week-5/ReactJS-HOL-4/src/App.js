// HOL 4 - State in React
// State is data that belongs to a component and can change
import React from 'react';
import Counter from './components/Counter';
import ToggleMessage from './components/ToggleMessage';
import ColorChanger from './components/ColorChanger';

function App() {
  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h1>HOL 4 - State in React</h1>
      <p>State is data that can change. When state changes React re-renders the component.</p>
      <hr />
      <Counter />
      <hr />
      <ToggleMessage />
      <hr />
      <ColorChanger />
    </div>
  );
}

export default App;
