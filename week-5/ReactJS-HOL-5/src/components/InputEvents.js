// InputEvents - shows keyboard and input events
import React, { useState } from 'react';

function InputEvents() {
  const [inputValue, setInputValue] = useState('');
  const [lastKey, setLastKey] = useState('');

  return (
    <div style={{ border: '1px solid #ccc', padding: '20px', margin: '10px', borderRadius: '5px' }}>
      <h2>Input Events</h2>

      {/* onChange fires every time user types something */}
      <input
        type="text"
        placeholder="Type something here..."
        value={inputValue}
        onChange={(e) => setInputValue(e.target.value)}
        onKeyDown={(e) => setLastKey(e.key)}
        style={{ padding: '8px', width: '300px', fontSize: '16px', border: '1px solid #ccc', borderRadius: '3px' }}
      />

      <p>You typed: <strong>{inputValue}</strong></p>
      <p>Total characters: <strong>{inputValue.length}</strong></p>
      <p>Last key pressed: <strong>{lastKey}</strong></p>
    </div>
  );
}

export default InputEvents;
