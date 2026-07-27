// StudentCard component - shows student information
// I can reuse this component multiple times with different data
import React from 'react';

function StudentCard() {
  return (
    <div style={{ border: '1px solid #ccc', padding: '15px', margin: '10px', borderRadius: '5px', width: '250px', display: 'inline-block' }}>
      <h3>Rahul Kumar</h3>
      <p><strong>Course:</strong> Java Full Stack</p>
      <p><strong>Batch:</strong> DN5 2026</p>
      <p><strong>Status:</strong> <span style={{ color: 'green' }}>Active</span></p>
    </div>
  );
}

export default StudentCard;
