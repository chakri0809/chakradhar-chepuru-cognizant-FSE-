// ColorChanger - changes background color using state
import React, { useState } from 'react';

function ColorChanger() {
  const [color, setColor] = useState('white');

  return (
    <div style={{ border: '1px solid #ccc', padding: '20px', margin: '10px', borderRadius: '5px', backgroundColor: color }}>
      <h2>Color Changer</h2>
      <p>Current Color: {color}</p>

      <button onClick={() => setColor('red')} style={{ margin: '5px', padding: '10px', backgroundColor: 'red', color: 'white', border: 'none', borderRadius: '3px', cursor: 'pointer' }}>Red</button>
      <button onClick={() => setColor('blue')} style={{ margin: '5px', padding: '10px', backgroundColor: 'blue', color: 'white', border: 'none', borderRadius: '3px', cursor: 'pointer' }}>Blue</button>
      <button onClick={() => setColor('green')} style={{ margin: '5px', padding: '10px', backgroundColor: 'green', color: 'white', border: 'none', borderRadius: '3px', cursor: 'pointer' }}>Green</button>
      <button onClick={() => setColor('white')} style={{ margin: '5px', padding: '10px', backgroundColor: '#333', color: 'white', border: 'none', borderRadius: '3px', cursor: 'pointer' }}>Reset</button>
    </div>
  );
}

export default ColorChanger;
