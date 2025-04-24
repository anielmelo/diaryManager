import { useEffect, useState } from "react";
import { getPosts } from "../api.js";
import PostForm from "../components/PostForm.jsx";
import PostCard from "../components/PostCard.jsx";  // Não esqueça de importar o PostCard
import vectorImg from "../assets/Vector2.png";
import Navbar from "../components/Navbar.jsx";

function Home() {
  const [posts, setPosts] = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const postsPerPage = 6;

  useEffect(() => {
    const fetchPosts = async () => {
      const data = await getPosts();
      if (data.length > 0) {
        setPosts(data);
      }
    };

    fetchPosts();
  }, []);

  const indexOfLastPost = currentPage * postsPerPage;
  const indexOfFirstPost = indexOfLastPost - postsPerPage;
  const currentPosts = posts.slice(indexOfFirstPost, indexOfLastPost);

  const paginate = (pageNumber) => setCurrentPage(pageNumber);

  const pageNumbers = Array.from(
    { length: Math.ceil(posts.length / postsPerPage) },
    (_, i) => i + 1
  );

  const handleAddPost = (newPost) => {
    console.log("Novo post adicionado:", newPost);  // Log para depuração
    setPosts((prevPosts) => [newPost, ...prevPosts]); // Adiciona o novo post no início
  };

  return (
    <div className="home">
      <Navbar /> 
      <h1>Postagens</h1>

      {posts.length === 0 ? (
        <p>Nenhum post disponível.</p>
      ) : (
        <div className="post-grid">
          {currentPosts.map((post) => (
            <PostCard key={post.id} post={post} />
          ))}
        </div>
      )}

      <div className="pagination">
        {pageNumbers.map((number) => (
          <button
            key={number}
            onClick={() => paginate(number)}
            className={number === currentPage ? "active" : ""}
          >
            {number}
          </button>
        ))}
      </div>

      <div className="Form">
        <PostForm onAddPost={handleAddPost} />
      </div>

      <div>
        <img src={vectorImg} alt="Descrição da imagem" className="vectorImage" />
      </div>
    </div>
  );
}

export default Home;
