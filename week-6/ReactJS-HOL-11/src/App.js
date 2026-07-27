// HOL 11 - Form Validation
import React from 'react';
import LoginForm from './components/LoginForm';
import RegisterValidation from './components/RegisterValidation';

function App() {
  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h1>HOL 11 - Form Validation in React</h1>
      <hr />
      <h2>Login Form</h2>
      <LoginForm />
      <hr />
      <h2>Registration Form with Validation</h2>
      <RegisterValidation />
    </div>
  );
}

export default App;
