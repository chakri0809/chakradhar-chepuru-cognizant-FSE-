// Toggle component - show and hide message using state
import React, { useState } from 'react';

function ToggleMessage() {
  // isVisible is boolean state - true = show, false = hide
  const [isVisible, setIsVisible] = useState(false);

  return (
    <div style={{ border: '1px solid #ccc', padding: '20px', margin: '10px', borderRadius: '5px' }}>
      <h2>Toggle Message</h2>

      <button onClick={() => setIsVisible(!isVisible)} style={{ padding: '10px 20px', backgroundColor: '#1A56BB', color: 'white', border: 'none', borderRadius: '3px', cursor: 'pointer' }}>
        {isVisible ? 'Hide Message' : 'Show Message'}
      </button>

      {/* show message only when isVisible is true */}
      {isVisible && (
        <p style={{ color: 'green', fontWeight: 'bold', marginTop: '10px' }}>
          Hello! This message is shown using React State!
        </p>
      )}
    </div>
  );
}

export default ToggleMessage;
