// FormEvents - shows form submit event
import React, { useState } from 'react';

function FormEvents() {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [submitted, setSubmitted] = useState(false);

  function handleSubmit(event) {
    // preventDefault stops the page from refreshing on form submit
    event.preventDefault();
    console.log('Form submitted with name:', name, 'email:', email);
    setSubmitted(true);
  }

  return (
    <div style={{ border: '1px solid #ccc', padding: '20px', margin: '10px', borderRadius: '5px' }}>
      <h2>Form Events</h2>

      <form onSubmit={handleSubmit}>
        <div style={{ marginBottom: '10px' }}>
          <label>Name: </label>
          <input
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
            placeholder="Enter your name"
            style={{ padding: '8px', marginLeft: '5px', border: '1px solid #ccc', borderRadius: '3px' }}
          />
        </div>
        <div style={{ marginBottom: '10px' }}>
          <label>Email: </label>
          <input
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            placeholder="Enter your email"
            style={{ padding: '8px', marginLeft: '5px', border: '1px solid #ccc', borderRadius: '3px' }}
          />
        </div>
        <button type="submit" style={{ padding: '10px 20px', backgroundColor: '#1A56BB', color: 'white', border: 'none', borderRadius: '3px', cursor: 'pointer' }}>
          Submit Form
        </button>
      </form>

      {submitted && (
        <div style={{ marginTop: '15px', padding: '10px', backgroundColor: '#d4edda', border: '1px solid green', borderRadius: '3px' }}>
          <p style={{ color: 'green' }}>Form Submitted!</p>
          <p>Name: {name}</p>
          <p>Email: {email}</p>
        </div>
      )}
    </div>
  );
}

export default FormEvents;
