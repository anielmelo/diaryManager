let posts = [];

export const getPosts = async () => {
  return posts;
};

export const getPostById = async (id) => {
  return posts.find((post) => post.id.toString() === id);
};

export const createPost = async (formData) => {
  const title = formData.get("title");
  const text = formData.get("text");
  const imageFile = formData.get("image");

  // Simulando upload da imagem localmente (usando URL.createObjectURL)
  const imageUrl = URL.createObjectURL(imageFile);

  const newPost = {
    id: Date.now(), 
    title,
    text,
    image: imageUrl, // A imagem é armazenada localmente como URL temporária
    dataHora: new Date(),
  };

  posts.push(newPost); // Adiciona o novo post à lista 
  return newPost; // Retorna o post recém-criado
};
