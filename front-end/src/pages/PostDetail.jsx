import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { getPostById } from '../api.js';

function PostDetail() {
  const { id } = useParams();
  const [post, setPost] = useState(null);

  useEffect(() => {
    getPostById(id).then(setPost);
  }, [id]);

  if (!post) return <p>Carregando...</p>;

  return (
    <div className="post-detail">
      <h2>{post.title}</h2>
      <img src={post.image} alt="Post" />
      <p>{post.text}</p>
      <p><small>{new Date(post.dataHora).toLocaleString()}</small></p>
    </div>
  );
}

export default PostDetail;
