// CourseCard component - shows course info using props
import React from 'react';

function CourseCard(props) {
  return (
    <div style={{ border: '2px solid #1A56BB', padding: '15px', margin: '10px', borderRadius: '5px', width: '220px', display: 'inline-block', verticalAlign: 'top' }}>
      <h3>{props.courseName}</h3>
      <p><strong>Duration:</strong> {props.duration}</p>
      <p><strong>Technology:</strong> {props.technology}</p>
      <p><strong>Instructor:</strong> {props.instructor}</p>
    </div>
  );
}

export default CourseCard;
