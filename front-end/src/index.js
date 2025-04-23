import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import App from './App';
import PostDetail from './PostDetail';

ReactDOM.render(
  <Router>
    <Routes>
      <Route path="/" element={<App />} />
      <Route path="/post/:id" element={<PostDetail />} />
    </Routes>
  </Router>,
  document.getElementById('root')
);
