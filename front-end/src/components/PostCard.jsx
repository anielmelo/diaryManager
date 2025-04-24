import { Link } from "react-router-dom";
import styles from './PostCard.module.css';
import vectorImg from '../assets/Vector.png'; // Caminho correto para a imagem

function PostCard({ post }) {
  const resumo = post.text;

  return (
    <div className={styles.postCard} style={{ backgroundImage: `url(${vectorImg})` }}>
      <h2>{post.title}</h2>
      <img src={post.image} alt={post.title} className={styles.cardImage} />
      <p className={styles.resumo}>{resumo}</p>
      <Link to={`/post/${post.id}`}>
        <button>VER MAIS</button>
      </Link>
    </div>
  );
}

export default PostCard;
