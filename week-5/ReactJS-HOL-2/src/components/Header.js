// Header component - this is the top section of my app
// A component is like a custom HTML element we can reuse
import React from 'react';

function Header() {
  return (
    <div style={{ backgroundColor: '#1A56BB', color: 'white', padding: '15px', textAlign: 'center' }}>
      <h1>Cognizant Digital Nurture 5.0</h1>
      <p>Learning React Components - HOL 2</p>
    </div>
  );
}

export default Header;
