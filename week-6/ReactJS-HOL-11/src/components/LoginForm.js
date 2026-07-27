// Login Form with basic validation
// Validation = checking user input before submitting
import React, { useState } from 'react';

function LoginForm() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [errors, setErrors] = useState({});
  const [loginSuccess, setLoginSuccess] = useState(false);

  function validate() {
    const newErrors = {};

    // check username
    if (username === '') {
      newErrors.username = 'Username is required';
    } else if (username.length < 3) {
      newErrors.username = 'Username must be at least 3 characters';
    }

    // check password
    if (password === '') {
      newErrors.password = 'Password is required';
    } else if (password.length < 6) {
      newErrors.password = 'Password must be at least 6 characters';
    }

    return newErrors;
  }

  function handleSubmit(event) {
    event.preventDefault();
    const newErrors = validate();

    if (Object.keys(newErrors).length > 0) {
      // there are errors - show them
      setErrors(newErrors);
      setLoginSuccess(false);
    } else {
      // no errors - login success
      setErrors({});
      setLoginSuccess(true);
      console.log('Login successful for:', username);
    }
  }

  return (
    <div style={{ maxWidth: '400px', margin: '0 auto', padding: '20px', border: '1px solid #ccc', borderRadius: '5px' }}>
      <h2>Login</h2>

      <form onSubmit={handleSubmit}>
        <div style={{ marginBottom: '15px' }}>
          <label>Username:</label><br />
          <input
            type="text"
            value={username}
            onChange={(e) => {
              setUsername(e.target.value);
              // clear error when user types
              if (errors.username) setErrors({ ...errors, username: '' });
            }}
            placeholder="Enter username"
            style={{ width: '100%', padding: '8px', boxSizing: 'border-box', border: errors.username ? '1px solid red' : '1px solid #ccc', borderRadius: '3px' }}
          />
          {/* show error message */}
          {errors.username && <p style={{ color: 'red', margin: '3px 0', fontSize: '13px' }}>{errors.username}</p>}
        </div>

        <div style={{ marginBottom: '15px' }}>
          <label>Password:</label><br />
          <input
            type="password"
            value={password}
            onChange={(e) => {
              setPassword(e.target.value);
              if (errors.password) setErrors({ ...errors, password: '' });
            }}
            placeholder="Enter password"
            style={{ width: '100%', padding: '8px', boxSizing: 'border-box', border: errors.password ? '1px solid red' : '1px solid #ccc', borderRadius: '3px' }}
          />
          {errors.password && <p style={{ color: 'red', margin: '3px 0', fontSize: '13px' }}>{errors.password}</p>}
        </div>

        <button type="submit" style={{ width: '100%', padding: '10px', backgroundColor: '#1A56BB', color: 'white', border: 'none', borderRadius: '3px', cursor: 'pointer' }}>
          Login
        </button>
      </form>

      {loginSuccess && (
        <div style={{ marginTop: '15px', padding: '10px', backgroundColor: '#d4edda', border: '1px solid green', borderRadius: '3px' }}>
          <p style={{ color: 'green', fontWeight: 'bold' }}>Login Successful! Welcome {username}!</p>
        </div>
      )}
    </div>
  );
}

export default LoginForm;
