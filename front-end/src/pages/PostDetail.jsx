// import { useEffect, useState } from 'react';
// import { useParams } from 'react-router-dom';
// import { getPostById } from '../api.js';

// function PostDetail() {
//   const { id } = useParams();
//   const [post, setPost] = useState(null);

//   useEffect(() => {
//     getPostById(id).then(setPost);
//   }, [id]);

//   if (!post) return <p>Carregando...</p>;

//   return (
//     <div className="post-detail">
//       <h2>{post.title}</h2>
//       <img src={post.image} alt="Post" />
//       <p>{post.text}</p>
//       <p><small>{new Date(post.dataHora).toLocaleString()}</small></p>
//     </div>
//   );
// }

// export default PostDetail;

// import { useEffect, useState } from 'react';
// import { useParams } from 'react-router-dom';
// import { getPostById } from '../api.js';
// import styles from './PostDetail.module.css';

// function PostDetail() {
//   const { id } = useParams();
//   const [post, setPost] = useState(null);

//   useEffect(() => {
//     getPostById(id).then(setPost);
//   }, [id]);

//   if (!post) return <p>Carregando...</p>;

//   return (
//     <div className={styles.container}>
//       <div className={styles.box}>
//         <div className={styles.buttons}>
//           <button>←</button>
//           <button>✎</button>
//           <button>🗑️</button>
//         </div>

//         <div className={styles.imageWrapper}>
//           <img src={post.image} alt="Post" />
//         </div>

//         <div className={styles.content}>
//           <h2>{post.title}</h2>
//           <p className={styles.date}>
//             {new Date(post.dataHora).toLocaleDateString()}
//           </p>
//           <p className={styles.text}>{post.text}</p>
//         </div>
//       </div>
//     </div>
//   );
// }

// export default PostDetail;

import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { getPostById } from '../api.js';
import styles from './PostDetail.module.css';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faArrowLeft } from "@fortawesome/free-solid-svg-icons";
import { faPenToSquare, faTrashCan } from "@fortawesome/free-regular-svg-icons";



function PostDetail() {
  const { id } = useParams();
  const [post, setPost] = useState(null);

  useEffect(() => {
    getPostById(id).then(setPost);
  }, [id]);

  if (!post) return <p>Carregando...</p>;

  return (
    <div className={styles.wrapper}>
      <div className={styles.card}>
        <div className={styles.header}>
          <button aria-label="Voltar" className={styles.button}>
            <FontAwesomeIcon icon={faArrowLeft} color="#3E3023" size="lg" />
          </button>
          <button aria-label="Editar" className={styles.button}>
            <FontAwesomeIcon icon={faPenToSquare} color="#3E3023" size="lg" />
            <FontAwesomeIcon icon="fa-regular fa-pen-to-square" />
          </button>
          <button aria-label="Excluir" className={styles.button}>
            <FontAwesomeIcon icon={faTrashCan} color="#3E3023" size="lg" />
          </button>
        </div>
        <div className={styles.body}>
          <img src={post.image} alt="Post" className={styles.image} />
          <div className={styles.content}>
            <div className={styles.title}>{post.title}</div>
            <div className={styles.date}>
              {new Date(post.dataHora).toLocaleDateString()}
            </div>
            <div className={styles.postTextContainer}>{post.text}</div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default PostDetail;


