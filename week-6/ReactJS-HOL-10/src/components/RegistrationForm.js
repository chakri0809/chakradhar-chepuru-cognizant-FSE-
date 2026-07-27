// Registration Form using controlled inputs
// Controlled input = React controls the value via state
import React, { useState } from 'react';

function RegistrationForm() {
  // all form fields stored in one state object
  const [formData, setFormData] = useState({
    firstName: '',
    lastName: '',
    email: '',
    phone: '',
    course: 'Java FSE',
    gender: 'male',
    agreeTerms: false
  });

  const [submitted, setSubmitted] = useState(false);

  // one handler for all inputs
  function handleChange(event) {
    const name = event.target.name;
    const value = event.target.value;
    const type = event.target.type;
    const checked = event.target.checked;

    // for checkbox use checked value, for others use value
    setFormData({ ...formData, [name]: type === 'checkbox' ? checked : value });
  }

  function handleSubmit(event) {
    event.preventDefault();
    console.log('Form submitted:', formData);
    setSubmitted(true);
  }

  return (
    <div style={{ maxWidth: '500px', margin: '0 auto', padding: '20px', border: '1px solid #ccc', borderRadius: '5px' }}>
      <h2>Student Registration Form</h2>

      <form onSubmit={handleSubmit}>
        <div style={{ marginBottom: '10px' }}>
          <label>First Name:</label><br />
          <input type="text" name="firstName" value={formData.firstName} onChange={handleChange} placeholder="First Name" style={{ width: '100%', padding: '8px', boxSizing: 'border-box' }} />
        </div>

        <div style={{ marginBottom: '10px' }}>
          <label>Last Name:</label><br />
          <input type="text" name="lastName" value={formData.lastName} onChange={handleChange} placeholder="Last Name" style={{ width: '100%', padding: '8px', boxSizing: 'border-box' }} />
        </div>

        <div style={{ marginBottom: '10px' }}>
          <label>Email:</label><br />
          <input type="email" name="email" value={formData.email} onChange={handleChange} placeholder="Email" style={{ width: '100%', padding: '8px', boxSizing: 'border-box' }} />
        </div>

        <div style={{ marginBottom: '10px' }}>
          <label>Phone:</label><br />
          <input type="tel" name="phone" value={formData.phone} onChange={handleChange} placeholder="Phone Number" style={{ width: '100%', padding: '8px', boxSizing: 'border-box' }} />
        </div>

        <div style={{ marginBottom: '10px' }}>
          <label>Course:</label><br />
          <select name="course" value={formData.course} onChange={handleChange} style={{ width: '100%', padding: '8px' }}>
            <option value="Java FSE">Java Full Stack</option>
            <option value="React">React Development</option>
            <option value="Spring Boot">Spring Boot</option>
            <option value="DevOps">DevOps</option>
            <option value="AWS">AWS Cloud</option>
          </select>
        </div>

        <div style={{ marginBottom: '10px' }}>
          <label>Gender:</label><br />
          <input type="radio" name="gender" value="male" checked={formData.gender === 'male'} onChange={handleChange} /> Male
          <input type="radio" name="gender" value="female" checked={formData.gender === 'female'} onChange={handleChange} style={{ marginLeft: '10px' }} /> Female
        </div>

        <div style={{ marginBottom: '10px' }}>
          <input type="checkbox" name="agreeTerms" checked={formData.agreeTerms} onChange={handleChange} />
          <label> I agree to the terms and conditions</label>
        </div>

        <button type="submit" style={{ width: '100%', padding: '10px', backgroundColor: '#1A56BB', color: 'white', border: 'none', borderRadius: '3px', cursor: 'pointer', fontSize: '16px' }}>
          Register
        </button>
      </form>

      {submitted && (
        <div style={{ marginTop: '15px', padding: '15px', backgroundColor: '#d4edda', border: '1px solid green', borderRadius: '3px' }}>
          <h3 style={{ color: 'green' }}>Registration Successful!</h3>
          <p>Name: {formData.firstName} {formData.lastName}</p>
          <p>Email: {formData.email}</p>
          <p>Phone: {formData.phone}</p>
          <p>Course: {formData.course}</p>
          <p>Gender: {formData.gender}</p>
          <p>Agreed to Terms: {formData.agreeTerms ? 'Yes' : 'No'}</p>
        </div>
      )}
    </div>
  );
}

export default RegistrationForm;
