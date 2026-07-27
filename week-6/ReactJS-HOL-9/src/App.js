// HOL 9 - Lists and Keys in React
import React from 'react';
import StudentList from './components/StudentList';
import CourseList from './components/CourseList';

function App() {
  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h1>HOL 9 - Lists and Keys</h1>
      <hr />
      <StudentList />
      <hr />
      <CourseList />
    </div>
  );
}

export default App;
