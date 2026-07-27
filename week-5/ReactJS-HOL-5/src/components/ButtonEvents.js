// ButtonEvents - shows different mouse events in React
import React, { useState } from 'react';

function ButtonEvents() {
  const [message, setMessage] = useState('Click or hover the buttons below');

  return (
    <div style={{ border: '1px solid #ccc', padding: '20px', margin: '10px', borderRadius: '5px' }}>
      <h2>Button Events</h2>

      {/* onClick event */}
      <button
        onClick={() => setMessage('Button was clicked!')}
        style={{ margin: '5px', padding: '10px', backgroundColor: '#1A56BB', color: 'white', border: 'none', borderRadius: '3px', cursor: 'pointer' }}
      >
        Click Me
      </button>

      {/* onMouseOver and onMouseOut events */}
      <button
        onMouseOver={() => setMessage('Mouse is hovering over the button!')}
        onMouseOut={() => setMessage('Mouse left the button!')}
        style={{ margin: '5px', padding: '10px', backgroundColor: 'green', color: 'white', border: 'none', borderRadius: '3px', cursor: 'pointer' }}
      >
        Hover Over Me
      </button>

      {/* onDoubleClick event */}
      <button
        onDoubleClick={() => setMessage('Button was double clicked!')}
        style={{ margin: '5px', padding: '10px', backgroundColor: 'orange', color: 'white', border: 'none', borderRadius: '3px', cursor: 'pointer' }}
      >
        Double Click Me
      </button>

      <p style={{ marginTop: '10px', fontWeight: 'bold', color: '#333' }}>Event: {message}</p>
    </div>
  );
}

export default ButtonEvents;
