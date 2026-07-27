// Fetching data using Axios
// Axios is simpler than Fetch - no need to call .json()
import React, { useState, useEffect } from 'react';
import axios from 'axios';

function AxiosPosts() {
  const [posts, setPosts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [selectedPost, setSelectedPost] = useState(null);

  useEffect(() => {
    // axios automatically converts response to JSON
    axios.get('https://jsonplaceholder.typicode.com/posts?_limit=5')
      .then(response => {
        // axios puts data in response.data
        setPosts(response.data);
        setLoading(false);
      })
      .catch(err => {
        setError(err.message);
        setLoading(false);
      });
  }, []);

  function viewPost(id) {
    axios.get('https://jsonplaceholder.typicode.com/posts/' + id)
      .then(response => setSelectedPost(response.data));
  }

  if (loading) return <p>Loading posts...</p>;
  if (error) return <p style={{ color: 'red' }}>{error}</p>;

  return (
    <div>
      <h3>Posts from API (using Axios)</h3>
      {posts.map(post => (
        <div key={post.id} style={{ border: '1px solid #ccc', padding: '10px', margin: '5px', borderRadius: '5px' }}>
          <strong>{post.title}</strong>
          <p style={{ color: '#666', fontSize: '14px' }}>{post.body.substring(0, 80)}...</p>
          <button onClick={() => viewPost(post.id)} style={{ padding: '5px 10px', backgroundColor: '#1A56BB', color: 'white', border: 'none', borderRadius: '3px', cursor: 'pointer' }}>
            View Details
          </button>
        </div>
      ))}

      {selectedPost && (
        <div style={{ marginTop: '15px', padding: '15px', backgroundColor: '#f0f8ff', border: '1px solid #1A56BB', borderRadius: '5px' }}>
          <h4>Selected Post Details:</h4>
          <p><strong>Title:</strong> {selectedPost.title}</p>
          <p><strong>Body:</strong> {selectedPost.body}</p>
          <button onClick={() => setSelectedPost(null)} style={{ padding: '5px 10px', backgroundColor: 'red', color: 'white', border: 'none', borderRadius: '3px', cursor: 'pointer' }}>Close</button>
        </div>
      )}
    </div>
  );
}

export default AxiosPosts;
