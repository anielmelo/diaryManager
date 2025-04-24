import styles from './ConfirmDeleteModal.module.css';

function ConfirmDeleteModal({ onConfirm, onCancel }) {
  return (
    <div className={styles.overlay}>
      <div className={styles.modal}>
        <h2 className={styles.h2} >Excluir postagem?</h2>
        <p>Ao excluir essa postagem ela não poderá ser recuperada.</p>
        <div className={styles.buttons}>
          <button onClick={onCancel} className={styles.cancel}>cancelar</button>
          <button onClick={onConfirm} className={styles.delete}>excluir</button>
        </div>
      </div>
    </div>
  );
}

export default ConfirmDeleteModal;