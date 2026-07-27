// Counter component - shows how useState works
// State = data that can change inside a component
// When state changes React automatically re-renders the component
import React, { useState } from 'react';

function Counter() {
  // useState(0) creates a state variable called count with initial value 0
  // setCount is the function we use to change count
  const [count, setCount] = useState(0);

  return (
    <div style={{ border: '1px solid #ccc', padding: '20px', margin: '10px', borderRadius: '5px' }}>
      <h2>Counter</h2>
      <h3 style={{ fontSize: '40px', color: '#1A56BB' }}>{count}</h3>

      {/* when button clicked we change state */}
      <button onClick={() => setCount(count + 1)} style={{ margin: '5px', padding: '10px 20px', backgroundColor: 'green', color: 'white', border: 'none', borderRadius: '3px', cursor: 'pointer' }}>
        Increase
      </button>
      <button onClick={() => setCount(count - 1)} style={{ margin: '5px', padding: '10px 20px', backgroundColor: 'red', color: 'white', border: 'none', borderRadius: '3px', cursor: 'pointer' }}>
        Decrease
      </button>
      <button onClick={() => setCount(0)} style={{ margin: '5px', padding: '10px 20px', backgroundColor: 'grey', color: 'white', border: 'none', borderRadius: '3px', cursor: 'pointer' }}>
        Reset
      </button>

      <p>You clicked {count} times</p>
    </div>
  );
}

export default Counter;
