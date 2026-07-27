// StudentCard with Props
// Props = Properties = data we pass into a component from outside
// Like function parameters but for components
import React from 'react';

function StudentCard(props) {
  // we get the values from props
  const name = props.name;
  const course = props.course;
  const batch = props.batch;
  const status = props.status;

  // change color based on status
  const statusColor = status === 'Active' ? 'green' : 'red';

  return (
    <div style={{ border: '1px solid #ccc', padding: '15px', margin: '10px', borderRadius: '5px', width: '220px', display: 'inline-block', verticalAlign: 'top' }}>
      <h3>{name}</h3>
      <p><strong>Course:</strong> {course}</p>
      <p><strong>Batch:</strong> {batch}</p>
      <p><strong>Status:</strong> <span style={{ color: statusColor }}>{status}</span></p>
    </div>
  );
}

export default StudentCard;
