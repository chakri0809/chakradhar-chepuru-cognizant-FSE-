import React, { useState, useEffect } from 'react';
function App() {
  const[books,setBooks]=useState([]);
  const[title,setTitle]=useState('');
  const[author,setAuthor]=useState('');
  const[price,setPrice]=useState('');
  useEffect(()=>{
    fetchBooks();
  },[]);
  const fetchBooks=()=>{
    fetch('http://localhost:8080/api/books')
      .then(res=>res.json())
      .then(data=>setBooks(data))
      .catch(err=>console.error(err));
  };
  const handleSubmit=(e)=>{
    e.preventDefault();
    if(!title||!author||!price)return;
    const newBook={title,author,price:parseFloat(price)};
    fetch('http://localhost:8080/api/books',{
      method:'POST',
      headers:{'Content-Type':'application/json'},
      body:JSON.stringify(newBook)
    })
      .then(res=>res.json())
      .then(()=>{
        setTitle('');
        setAuthor('');
        setPrice('');
        fetchBooks();
      })
      .catch(err=>console.error(err));
  };
  return (
    <div className="container">
      <h1>Library Management System</h1>
      <h2>Add New Book</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Title</label>
          <input type="text" value={title} onChange={e=>setTitle(e.target.value)} />
        </div>
        <div className="form-group">
          <label>Author</label>
          <input type="text" value={author} onChange={e=>setAuthor(e.target.value)} />
        </div>
        <div className="form-group">
          <label>Price</label>
          <input type="number" step="0.01" value={price} onChange={e=>setPrice(e.target.value)} />
        </div>
        <button type="submit">Add Book</button>
      </form>
      <h2>Book Collection</h2>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>Price</th>
          </tr>
        </thead>
        <tbody>
          {books.map(b=>(
            <tr key={b.id}>
              <td>{b.id}</td>
              <td>{b.title}</td>
              <td>{b.author}</td>
              <td>${b.price}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
export default App;
