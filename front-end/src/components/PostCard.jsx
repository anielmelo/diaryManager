import { Link } from "react-router-dom";
import styles from './PostCard.module.css';

function PostCard({ post }) {
  const resumo = post.text;

  return (
    <div className={styles.postCard}>
      <h2>{post.title}</h2>
      <img src={post.image} alt={post.title} />
      <p>{resumo}</p>
      <Link to={`/post/${post.id}`}>
        <button>VER MAIS</button>
      </Link>
    </div>
  );
}

export default PostCard;
