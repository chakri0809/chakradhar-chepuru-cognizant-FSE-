// Form to add new student
import React, { useState } from 'react';

function StudentForm({ onAddStudent }) {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [course, setCourse] = useState('Java FSE');
  const [errors, setErrors] = useState({});

  function handleSubmit(e) {
    e.preventDefault();
    const newErrors = {};
    if (!name) newErrors.name = 'Name is required';
    if (!email || !email.includes('@')) newErrors.email = 'Valid email is required';

    if (Object.keys(newErrors).length > 0) {
      setErrors(newErrors);
      return;
    }

    // call parent function to add student
    onAddStudent({ name, email, course });

    // reset form
    setName('');
    setEmail('');
    setCourse('Java FSE');
    setErrors({});
  }

  return (
    <div style={{ padding: '20px', maxWidth: '400px' }}>
      <h2>Add New Student</h2>
      <form onSubmit={handleSubmit}>
        <div style={{ marginBottom: '10px' }}>
          <label>Name:</label><br />
          <input type="text" value={name} onChange={e => { setName(e.target.value); setErrors({ ...errors, name: '' }); }} placeholder="Student name" style={{ width: '100%', padding: '8px', boxSizing: 'border-box', border: errors.name ? '1px solid red' : '1px solid #ccc', borderRadius: '3px' }} />
          {errors.name && <p style={{ color: 'red', fontSize: '12px', margin: '2px 0' }}>{errors.name}</p>}
        </div>
        <div style={{ marginBottom: '10px' }}>
          <label>Email:</label><br />
          <input type="email" value={email} onChange={e => { setEmail(e.target.value); setErrors({ ...errors, email: '' }); }} placeholder="Student email" style={{ width: '100%', padding: '8px', boxSizing: 'border-box', border: errors.email ? '1px solid red' : '1px solid #ccc', borderRadius: '3px' }} />
          {errors.email && <p style={{ color: 'red', fontSize: '12px', margin: '2px 0' }}>{errors.email}</p>}
        </div>
        <div style={{ marginBottom: '15px' }}>
          <label>Course:</label><br />
          <select value={course} onChange={e => setCourse(e.target.value)} style={{ width: '100%', padding: '8px' }}>
            <option value="Java FSE">Java Full Stack</option>
            <option value="React">React Development</option>
            <option value="Spring Boot">Spring Boot</option>
            <option value="DevOps">DevOps</option>
            <option value="AWS">AWS Cloud</option>
          </select>
        </div>
        <button type="submit" style={{ width: '100%', padding: '10px', backgroundColor: '#1A56BB', color: 'white', border: 'none', borderRadius: '3px', cursor: 'pointer' }}>
          Add Student
        </button>
      </form>
    </div>
  );
}

export default StudentForm;
