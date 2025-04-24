import { useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { getPostById, updatePostById, deletePostById } from '../api.js';
import styles from './UpdateDetail.module.css';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import ConfirmDeleteModal from '../components/ConfirmDeleteModal.jsx';
import UpdateForm from '../components/UpdateForm.jsx';

function UpdateDetail() {
  const { id } = useParams();
  const [post, setPost] = useState(null);
  const [showConfirmModal, setShowConfirmModal] = useState(false);
  const navigate = useNavigate();

  useEffect(() => {
    getPostById(id).then(setPost);
  }, [id]);

  

  const confirmDelete = async () => {
    try {
      await deletePostById(id);
      navigate('/');
    } catch (error) {
        console.error('Erro ao excluir o post:', error);
        alert('Erro ao excluir o post: ' + error.message);
    }
  };

  const handleUpdate = async (formData) => {
    try {
      await updatePostById(id, formData);
      navigate(`/post/${id}`);
    } catch (error) {
        console.error('Erro ao excluir o post:', error);
        alert('Erro ao excluir o post: ' + error.message);
    }
  };

  if (!post) return <p>Carregando...</p>;

  return (
    <div className={styles.wrapper}>
      {showConfirmModal && (
        <ConfirmDeleteModal 
          onConfirm={confirmDelete} 
          onCancel={() => setShowConfirmModal(false)} 
        />
      )}

      

      <UpdateForm postData={post} onSubmit={handleUpdate} />
    </div>
  );
}

export default UpdateDetail;
