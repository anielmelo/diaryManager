import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/post';

export const getPosts = async () => {
  const response = await axios.get(`${API_BASE_URL}/`);
  return response.data;
};

export const getPostById = async (id) => {
  const response = await axios.get(`${API_BASE_URL}/${id}`);
  return response.data;
};

export const createPost = async (formData) => {
  const title = formData.get("title");
  const text = formData.get("text");
  const imageUrl = formData.get("image");

  const newPost = {
    title,
    text,
    image: imageUrl
  };

  const response = await axios.post(`${API_BASE_URL}/`, newPost);
  return response.data;
};

// ----------------------------------------------------
// Agora delete e update usando API via HTTP:

export const deletePostById = async (id) => {
  try {
    const response = await axios.delete(`${API_BASE_URL}/${id}`);
    return response.data;  // pode ser uma mensagem ou objeto, depende da API
  } catch (error) {
    throw new Error(error.response?.data?.message || 'Erro ao deletar o post');
  }
};

export const updatePostById = async (id, formData) => {
  const title = formData.get("title");
  const text = formData.get("text");
  const image = formData.get("image"); // já é texto/URL

  const updatedPost = {
    title,
    text,
    image
  };

  try {
    const response = await axios.put(`${API_BASE_URL}/${id}`, updatedPost);
    return response.data;
  } catch (error) {
    throw new Error(error.response?.data?.message || 'Erro ao atualizar o post');
  }
};

