package br.edu.ifpb.esperanca.ads.diarymanager.diary.service;

import br.edu.ifpb.esperanca.ads.diarymanager.diary.domain.Post;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements IPostService {
    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    @Transactional
    public Post create(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi encontrado nenhum post com o id: " + id));
    }

    @Override
    public Post update(Long id, Post post) {
        Post postToUpdate = findById(id);

        Post newPost = new Post(
                postToUpdate.getId(),
                post.getTitle(),
                post.getText(),
                post.getImage(),
                postToUpdate.getCreatedAt());

        return postRepository.save(newPost);
    }

    @Override
    public void delete(Long id) {
        Post post = findById(id);
        postRepository.delete(post);
    }
}
