// Dashboard - shows total students and courses
import React from 'react';

function Dashboard({ students }) {
  const totalStudents = students.length;
  const courses = [...new Set(students.map(s => s.course))];

  return (
    <div style={{ display: 'flex', gap: '15px', padding: '15px', backgroundColor: '#f5f5f5' }}>
      <div style={{ backgroundColor: 'white', padding: '15px', borderRadius: '5px', border: '1px solid #ccc', flex: 1, textAlign: 'center' }}>
        <h3 style={{ color: '#1A56BB' }}>{totalStudents}</h3>
        <p>Total Students</p>
      </div>
      <div style={{ backgroundColor: 'white', padding: '15px', borderRadius: '5px', border: '1px solid #ccc', flex: 1, textAlign: 'center' }}>
        <h3 style={{ color: 'green' }}>{courses.length}</h3>
        <p>Courses</p>
      </div>
      <div style={{ backgroundColor: 'white', padding: '15px', borderRadius: '5px', border: '1px solid #ccc', flex: 1, textAlign: 'center' }}>
        <h3 style={{ color: 'orange' }}>{students.length > 0 ? students[students.length - 1].name : 'None'}</h3>
        <p>Latest Student</p>
      </div>
    </div>
  );
}

export default Dashboard;
