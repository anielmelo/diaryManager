import { useEffect, useState } from "react";
import { getPosts } from "../api.js"; // Ajuste a importação se necessário
import PostForm from "../components/PostForm.jsx";
import PostCard from "../components/PostCard.jsx";

function Home() {
  const [posts, setPosts] = useState([]); // Inicializa com um array vazio
  const [currentPage, setCurrentPage] = useState(1);
  const postsPerPage = 6;

  useEffect(() => {
    const fetchPosts = async () => {
      const data = await getPosts(); // Obtém os posts da "API"
      if (data.length > 0) {
        setPosts(data); // Se houver posts, atualiza o estado
      }
    };

    fetchPosts(); // Chama a função para carregar os posts ao montar o componente
  }, []); // A dependência vazia faz isso rodar apenas uma vez

  // Paginação
  const indexOfLastPost = currentPage * postsPerPage;
  const indexOfFirstPost = indexOfLastPost - postsPerPage;
  const currentPosts = posts.slice(indexOfFirstPost, indexOfLastPost);

  const paginate = (pageNumber) => setCurrentPage(pageNumber);

  // Gerar números de página
  const pageNumbers = Array.from(
    { length: Math.ceil(posts.length / postsPerPage) },
    (_, i) => i + 1
  );

  // Adicionar um novo post
  const handleAddPost = (newPost) => {
    setPosts((prevPosts) => [newPost, ...prevPosts]); // Adiciona o novo post no início
  };

  return (
    <div className="home">
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

      <PostForm onAddPost={handleAddPost} />
    </div>
  );
}

export default Home;
