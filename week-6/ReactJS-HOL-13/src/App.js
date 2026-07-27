// HOL 13 - Final React App
// This app combines everything: State, Props, Events, Lists, Forms, Validation
import React, { useState } from 'react';
import Navbar from './components/Navbar';
import Dashboard from './components/Dashboard';
import StudentForm from './components/StudentForm';
import StudentList from './components/StudentList';

function App() {
  // main state - list of all students
  const [students, setStudents] = useState([
    { id: 1, name: 'Rahul Kumar', email: 'rahul@test.com', course: 'Java FSE' },
    { id: 2, name: 'Priya Sharma', email: 'priya@test.com', course: 'React' }
  ]);

  // which tab is showing - list or form
  const [activeTab, setActiveTab] = useState('list');

  // add new student to the list
  function addStudent(studentData) {
    const newStudent = {
      id: Date.now(),
      name: studentData.name,
      email: studentData.email,
      course: studentData.course
    };
    setStudents([...students, newStudent]);
    setActiveTab('list');
    console.log('New student added:', newStudent);
  }

  // remove student from list
  function deleteStudent(id) {
    const updatedStudents = students.filter(s => s.id !== id);
    setStudents(updatedStudents);
    console.log('Student deleted with id:', id);
  }

  return (
    <div style={{ fontFamily: 'Arial', minHeight: '100vh' }}>
      {/* Navigation bar */}
      <Navbar />

      {/* Dashboard with stats */}
      <Dashboard students={students} />

      {/* Tab buttons */}
      <div style={{ padding: '10px 20px', borderBottom: '1px solid #ccc' }}>
        <button
          onClick={() => setActiveTab('list')}
          style={{ marginRight: '10px', padding: '8px 20px', backgroundColor: activeTab === 'list' ? '#1A56BB' : '#ccc', color: activeTab === 'list' ? 'white' : 'black', border: 'none', borderRadius: '3px', cursor: 'pointer' }}
        >
          Student List
        </button>
        <button
          onClick={() => setActiveTab('form')}
          style={{ padding: '8px 20px', backgroundColor: activeTab === 'form' ? '#1A56BB' : '#ccc', color: activeTab === 'form' ? 'white' : 'black', border: 'none', borderRadius: '3px', cursor: 'pointer' }}
        >
          Add Student
        </button>
      </div>

      {/* Show list or form based on active tab */}
      {activeTab === 'list' && <StudentList students={students} onDelete={deleteStudent} />}
      {activeTab === 'form' && <StudentForm onAddStudent={addStudent} />}

      {/* Footer */}
      <div style={{ textAlign: 'center', padding: '20px', backgroundColor: '#333', color: 'white', marginTop: '20px' }}>
        <p>Cognizant Digital Nurture 5.0 - React HOL 13</p>
      </div>
    </div>
  );
}

export default App;
