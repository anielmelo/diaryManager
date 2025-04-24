import { useState, useEffect } from "react";
import styles from './UpdateForm.module.css';

function UpdateForm({ postData, onSubmit }) {
  const [title, setTitle] = useState("");
  const [text, setText] = useState("");
  const [imageUrl, setImageUrl] = useState(""); // guarda a url da imagem

  useEffect(() => {
    if (postData) {
      setTitle(postData.title || "");
      setText(postData.text || "");
      setImageUrl(postData.image || "");
    }
  }, [postData]);

  const handleImageChange = (e) => {
    setImageUrl(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    const formData = new FormData();
    formData.append("title", title);
    formData.append("text", text);
    formData.append("image", imageUrl); // imagem como texto/url

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
            {imageUrl ? (
              <img src={imageUrl} alt="Preview" className={styles.updateImage} />
            ) : (
              <div className={styles.updateImagePlaceholder}>Sem imagem</div>
            )}

            <div className={styles.updateFormFields}>
              <label htmlFor="title">Título:</label>
              <input
                className={styles.updateInput}
                id="title"
                type="text"
                value={title}
                maxLength={50}
                onChange={(e) => setTitle(e.target.value)}
                required
              />

              <label htmlFor="image">URL da Imagem:</label>
              <input
                className={styles.updateInput}
                id="image"
                type="text"
                value={imageUrl}
                onChange={handleImageChange}
                placeholder="Cole a URL da imagem aqui"
              />

              <label htmlFor="text">Texto:</label>
              <textarea
                className={styles.updateTextArea}
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
