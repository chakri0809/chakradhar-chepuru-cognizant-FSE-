// CourseList - list with delete functionality
import React, { useState } from 'react';

function CourseList() {
  const [courses, setCourses] = useState([
    { id: 1, name: 'Java Full Stack', weeks: 7, status: 'Active' },
    { id: 2, name: 'React Development', weeks: 4, status: 'Active' },
    { id: 3, name: 'Spring Boot', weeks: 3, status: 'Completed' },
    { id: 4, name: 'DevOps', weeks: 2, status: 'Active' }
  ]);

  function deleteCourse(id) {
    // filter creates new array without the deleted item
    const newCourses = courses.filter(c => c.id !== id);
    setCourses(newCourses);
  }

  return (
    <div style={{ padding: '10px' }}>
      <h2>Course List</h2>
      {courses.map(course => (
        <div key={course.id} style={{ border: '1px solid #ccc', padding: '10px', margin: '5px', borderRadius: '5px', display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
          <div>
            <strong>{course.name}</strong>
            <span style={{ marginLeft: '15px' }}>Duration: {course.weeks} weeks</span>
            <span style={{ marginLeft: '15px', color: course.status === 'Active' ? 'green' : 'grey' }}>{course.status}</span>
          </div>
          <button onClick={() => deleteCourse(course.id)} style={{ backgroundColor: 'red', color: 'white', border: 'none', padding: '5px 10px', borderRadius: '3px', cursor: 'pointer' }}>
            Delete
          </button>
        </div>
      ))}
      <p>Total courses: {courses.length}</p>
    </div>
  );
}

export default CourseList;
