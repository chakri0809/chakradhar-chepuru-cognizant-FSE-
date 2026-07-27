// StudentList - showing a list of students using map()
// In React we use map() to render arrays of data
// Every item in a list needs a unique key prop
import React, { useState } from 'react';

function StudentList() {
  const students = [
    { id: 1, name: 'Rahul Kumar', course: 'Java FSE', grade: 'A' },
    { id: 2, name: 'Priya Sharma', course: 'React', grade: 'B' },
    { id: 3, name: 'Sam Wilson', course: 'Spring Boot', grade: 'A' },
    { id: 4, name: 'Anita Singh', course: 'DevOps', grade: 'B' },
    { id: 5, name: 'Dev Patel', course: 'AWS Cloud', grade: 'C' }
  ];

  const [filter, setFilter] = useState('ALL');

  // filter students based on grade
  const filteredStudents = filter === 'ALL' ? students : students.filter(s => s.grade === filter);

  return (
    <div style={{ padding: '10px' }}>
      <h2>Student List</h2>

      {/* filter buttons */}
      <button onClick={() => setFilter('ALL')} style={{ margin: '3px', padding: '5px 10px' }}>All</button>
      <button onClick={() => setFilter('A')} style={{ margin: '3px', padding: '5px 10px' }}>Grade A</button>
      <button onClick={() => setFilter('B')} style={{ margin: '3px', padding: '5px 10px' }}>Grade B</button>
      <button onClick={() => setFilter('C')} style={{ margin: '3px', padding: '5px 10px' }}>Grade C</button>

      {/* render list using map() */}
      <table style={{ borderCollapse: 'collapse', width: '100%', marginTop: '10px' }}>
        <thead>
          <tr style={{ backgroundColor: '#1A56BB', color: 'white' }}>
            <th style={{ border: '1px solid #ccc', padding: '8px' }}>ID</th>
            <th style={{ border: '1px solid #ccc', padding: '8px' }}>Name</th>
            <th style={{ border: '1px solid #ccc', padding: '8px' }}>Course</th>
            <th style={{ border: '1px solid #ccc', padding: '8px' }}>Grade</th>
          </tr>
        </thead>
        <tbody>
          {/* key prop must be unique - we use student id */}
          {filteredStudents.map(student => (
            <tr key={student.id}>
              <td style={{ border: '1px solid #ccc', padding: '8px' }}>{student.id}</td>
              <td style={{ border: '1px solid #ccc', padding: '8px' }}>{student.name}</td>
              <td style={{ border: '1px solid #ccc', padding: '8px' }}>{student.course}</td>
              <td style={{ border: '1px solid #ccc', padding: '8px' }}>{student.grade}</td>
            </tr>
          ))}
        </tbody>
      </table>
      <p>Showing {filteredStudents.length} students</p>
    </div>
  );
}

export default StudentList;
