// HOL 3 - Props Demo
// We pass different data to same component using props
// This shows how components are REUSABLE
import React from 'react';
import StudentCard from './components/StudentCard';
import CourseCard from './components/CourseCard';

function App() {
  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h1>HOL 3 - Props in React</h1>

      <h2>Student Cards - Same component different props</h2>
      {/* passing different props to same StudentCard component */}
      <StudentCard name="Rahul Kumar" course="Java FSE" batch="DN5 2026" status="Active" />
      <StudentCard name="Priya Sharma" course="React" batch="DN5 2026" status="Active" />
      <StudentCard name="Sam Wilson" course="Spring Boot" batch="DN5 2026" status="Inactive" />

      <h2>Course Cards</h2>
      <CourseCard courseName="Java Full Stack" duration="7 weeks" technology="Spring Boot React" instructor="John Smith" />
      <CourseCard courseName="Python ML" duration="8 weeks" technology="TensorFlow" instructor="Jane Doe" />
    </div>
  );
}

export default App;
