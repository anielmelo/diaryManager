import { useState } from "react";
import { createPost } from "../api.js";
import styles from './PostForm.module.css';


function PostForm({ onAddPost }) {
  const [title, setTitle] = useState("");
  const [image, setImage] = useState("");
  const [text, setText] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    const formData = new FormData();
    formData.append("title", title);
    formData.append("text", text);
    formData.append("image", image);

    const created = await createPost(formData);
    onAddPost(created);

    setTitle("");
    setText("");
    setImage("");
  };

  return (
    <form onSubmit={handleSubmit} className={styles.postForm}>
      <h1>Crie uma nova postagem!</h1>

      <p>Titulo</p>
      <input
        type="text"
        value={title}
        maxLength={25}
        onChange={(e) => setTitle(e.target.value)}
        required
      />
      <p>Imagem</p>
      <input
        type="text"
        value={image}
        maxLength={100}
        onChange={(e) => setImage(e.target.value)}
        required
      />
      <p>Texto Completo</p>
      <textarea
        value={text}
        onChange={(e) => setText(e.target.value)}
        required
      />

      <button type="submit">Adicionar</button>
    </form>
  );
}

export default PostForm;
