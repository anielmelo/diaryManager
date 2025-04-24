import { useState, useEffect } from "react";
import styles from './UpdateForm.module.css';

function UpdateForm({ postData, onSubmit }) {
  // Inicializa os estados com os dados recebidos da postagem
  const [title, setTitle] = useState("");
  const [text, setText] = useState("");
  const [imageFile, setImageFile] = useState(null);
  const [previewImage, setPreviewImage] = useState(null);

  // Atualiza os estados quando postData mudar (ex: carregou do backend)
  useEffect(() => {
    if (postData) {
      setTitle(postData.title || "");
      setText(postData.text || "");
      setPreviewImage(postData.image || null);
      setImageFile(null); // resetar novo arquivo
    }
  }, [postData]);

  // Atualiza a prévia da imagem ao selecionar nova imagem
  const handleImageChange = (e) => {
    const file = e.target.files[0];
    setImageFile(file);

    if (file) {
      const reader = new FileReader();
      reader.onloadend = () => setPreviewImage(reader.result);
      reader.readAsDataURL(file);
    } else {
      setPreviewImage(postData.image || null);
    }
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    const formData = new FormData();
    formData.append("title", title);
    formData.append("text", text);
    if (imageFile) {
      formData.append("image", imageFile);
    }

    onSubmit(formData);
  };

  return (
    <div className={styles.updateWrapper}>
      <div className={styles.updateCard}>
      <form onSubmit={handleSubmit} className={styles.updateFormContainer}>
        <div className={styles.updateFormHeader}>
            <h2>Editar Postagem</h2>
            <button type="submit" className={styles.updateButton}>
            Salvar Alterações
            </button>
        </div>

        <div className={styles.updateBody}>
            {previewImage ? (
            <img src={previewImage} alt="Preview" className={styles.updateImage} />
            ) : (
            <div className={styles.updateImagePlaceholder}>Sem imagem</div>
            )}

            <div className={styles.updateFormFields}>
            <label htmlFor="title">Título:</label>
            <input className={styles.updateInput}
                id="title"
                type="text"
                value={title}
                maxLength={50}
                onChange={(e) => setTitle(e.target.value)}
                required
            />

            <label htmlFor="image">Alterar Imagem:</label>
            <input className={styles.updateInput}
                id="image"
                type="file"
                accept="image/*"
                onChange={handleImageChange}
            />

            <label htmlFor="text">Texto:</label>
            <textarea className={styles.updateTextArea}
                id="text"
                value={text}
                onChange={(e) => setText(e.target.value)}
                required
            />
            </div>
        </div>
        </form>

      </div>
    </div>
  );
}

export default UpdateForm;
