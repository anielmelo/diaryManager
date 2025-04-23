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