// Shows list of students with delete option
import React from 'react';

function StudentList({ students, onDelete }) {
  if (students.length === 0) {
    return <p style={{ padding: '20px', color: '#666' }}>No students added yet. Click Add Student to add one.</p>;
  }

  return (
    <div style={{ padding: '20px' }}>
      <h2>All Students ({students.length})</h2>
      <table style={{ borderCollapse: 'collapse', width: '100%' }}>
        <thead>
          <tr style={{ backgroundColor: '#1A56BB', color: 'white' }}>
            <th style={{ border: '1px solid #ccc', padding: '10px' }}>Name</th>
            <th style={{ border: '1px solid #ccc', padding: '10px' }}>Email</th>
            <th style={{ border: '1px solid #ccc', padding: '10px' }}>Course</th>
            <th style={{ border: '1px solid #ccc', padding: '10px' }}>Action</th>
          </tr>
        </thead>
        <tbody>
          {students.map(student => (
            <tr key={student.id}>
              <td style={{ border: '1px solid #ccc', padding: '10px' }}>{student.name}</td>
              <td style={{ border: '1px solid #ccc', padding: '10px' }}>{student.email}</td>
              <td style={{ border: '1px solid #ccc', padding: '10px' }}>{student.course}</td>
              <td style={{ border: '1px solid #ccc', padding: '10px', textAlign: 'center' }}>
                <button onClick={() => onDelete(student.id)} style={{ backgroundColor: 'red', color: 'white', border: 'none', padding: '5px 10px', borderRadius: '3px', cursor: 'pointer' }}>
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default StudentList;
