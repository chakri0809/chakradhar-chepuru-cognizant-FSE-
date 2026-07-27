// HOL 5 - Events in React
import React from 'react';
import ButtonEvents from './components/ButtonEvents';
import InputEvents from './components/InputEvents';
import FormEvents from './components/FormEvents';

function App() {
  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h1>HOL 5 - Events in React</h1>
      <hr />
      <ButtonEvents />
      <hr />
      <InputEvents />
      <hr />
      <FormEvents />
    </div>
  );
}

export default App;
