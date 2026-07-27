// Registration with full validation
import React, { useState } from 'react';

function RegisterValidation() {
  const [formData, setFormData] = useState({ name: '', email: '', phone: '', password: '', confirmPassword: '' });
  const [errors, setErrors] = useState({});
  const [submitted, setSubmitted] = useState(false);

  function validate() {
    const newErrors = {};

    if (!formData.name) {
      newErrors.name = 'Name is required';
    } else if (formData.name.length < 2) {
      newErrors.name = 'Name must be at least 2 characters';
    }

    if (!formData.email) {
      newErrors.email = 'Email is required';
    } else if (!formData.email.includes('@')) {
      newErrors.email = 'Email must contain @ symbol';
    }

    if (!formData.phone) {
      newErrors.phone = 'Phone is required';
    } else if (!/^\d{10}$/.test(formData.phone)) {
      newErrors.phone = 'Phone must be 10 digits';
    }

    if (!formData.password) {
      newErrors.password = 'Password is required';
    } else if (formData.password.length < 8) {
      newErrors.password = 'Password must be at least 8 characters';
    }

    if (!formData.confirmPassword) {
      newErrors.confirmPassword = 'Please confirm your password';
    } else if (formData.password !== formData.confirmPassword) {
      newErrors.confirmPassword = 'Passwords do not match';
    }

    return newErrors;
  }

  function handleChange(e) {
    setFormData({ ...formData, [e.target.name]: e.target.value });
    if (errors[e.target.name]) setErrors({ ...errors, [e.target.name]: '' });
  }

  function handleSubmit(e) {
    e.preventDefault();
    const newErrors = validate();
    if (Object.keys(newErrors).length > 0) {
      setErrors(newErrors);
    } else {
      setErrors({});
      setSubmitted(true);
    }
  }

  const inputStyle = (field) => ({ width: '100%', padding: '8px', boxSizing: 'border-box', border: errors[field] ? '1px solid red' : '1px solid #ccc', borderRadius: '3px', marginTop: '3px' });

  return (
    <div style={{ maxWidth: '400px', margin: '0 auto', padding: '20px', border: '1px solid #ccc', borderRadius: '5px' }}>
      <h2>Register with Validation</h2>
      <form onSubmit={handleSubmit}>
        {['name', 'email', 'phone', 'password', 'confirmPassword'].map(field => (
          <div key={field} style={{ marginBottom: '12px' }}>
            <label>{field.charAt(0).toUpperCase() + field.slice(1)}:</label>
            <input type={field.includes('password') || field.includes('Password') ? 'password' : 'text'} name={field} value={formData[field]} onChange={handleChange} placeholder={`Enter ${field}`} style={inputStyle(field)} />
            {errors[field] && <p style={{ color: 'red', margin: '2px 0', fontSize: '12px' }}>{errors[field]}</p>}
          </div>
        ))}
        <button type="submit" style={{ width: '100%', padding: '10px', backgroundColor: '#1A56BB', color: 'white', border: 'none', borderRadius: '3px', cursor: 'pointer' }}>Register</button>
      </form>
      {submitted && <div style={{ marginTop: '10px', padding: '10px', backgroundColor: '#d4edda', border: '1px solid green', borderRadius: '3px' }}><p style={{ color: 'green' }}>Registration Successful!</p></div>}
    </div>
  );
}

export default RegisterValidation;
