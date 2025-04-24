import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Home from './pages/Home.jsx';
import PostDetail from './pages/PostDetail.jsx';
import UpdateDetail from './pages/UpdateDetail.jsx'

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/post/:id" element={<PostDetail />} />
        <Route path="/post/:id/editar" element={<UpdateDetail />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
