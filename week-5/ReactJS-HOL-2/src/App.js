// HOL 2 - React Components
// Components are the building blocks of React apps
// We compose multiple components together to build the UI
import React from 'react';
import Header from './components/Header';
import Footer from './components/Footer';
import StudentCard from './components/StudentCard';

function App() {
  return (
    <div>
      {/* Using Header component */}
      <Header />

      <div style={{ padding: '20px' }}>
        <h2>Student Information</h2>
        <p>Below are student cards - same component used 3 times</p>

        {/* Using StudentCard component 3 times */}
        <StudentCard />
        <StudentCard />
        <StudentCard />
      </div>

      {/* Using Footer component */}
      <Footer />
    </div>
  );
}

export default App;
