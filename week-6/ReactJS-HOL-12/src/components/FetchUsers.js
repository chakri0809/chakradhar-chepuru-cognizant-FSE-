// Fetching data from API using Fetch
// useEffect is used to call API when component loads
// useState stores the fetched data
import React, { useState, useEffect } from 'react';

function FetchUsers() {
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  // useEffect runs after component renders
  // empty array [] means run only once
  useEffect(() => {
    // calling free public API for testing
    fetch('https://jsonplaceholder.typicode.com/users')
      .then(response => response.json())
      .then(data => {
        setUsers(data);
        setLoading(false);
        console.log('Fetched users:', data.length);
      })
      .catch(err => {
        setError('Error fetching users: ' + err.message);
        setLoading(false);
      });
  }, []);

  if (loading) return <p>Loading users from API...</p>;
  if (error) return <p style={{ color: 'red' }}>{error}</p>;

  return (
    <div>
      <h3>Users from API (using Fetch)</h3>
      <p>Total users fetched: {users.length}</p>
      {users.map(user => (
        <div key={user.id} style={{ border: '1px solid #ccc', padding: '10px', margin: '5px', borderRadius: '5px' }}>
          <strong>{user.name}</strong>
          <p>Email: {user.email}</p>
          <p>Phone: {user.phone}</p>
          <p>Company: {user.company.name}</p>
        </div>
      ))}
    </div>
  );
}

export default FetchUsers;
