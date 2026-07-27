// Navbar - top navigation bar
import React from 'react';

function Navbar() {
  return (
    <div style={{ backgroundColor: '#1A56BB', color: 'white', padding: '15px 20px', display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
      <h2 style={{ margin: 0 }}>CZT DN5 Student Portal</h2>
      <span>{new Date().toLocaleDateString()}</span>
    </div>
  );
}

export default Navbar;
