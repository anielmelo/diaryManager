package br.edu.ifpb.esperanca.ads.diarymanager.diary.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifpb.esperanca.ads.diarymanager.diary.domain.Post;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.dto.PostRequestDTO;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.dto.PostResponseDTO;

@Service
public class PostService extends BaseService<PostRequestDTO, PostResponseDTO, Post, Long> {

    @Override
    public void create(PostRequestDTO requestDTO) {
        super.create(requestDTO);
    }

    @Override
    public void update(Long id, PostRequestDTO requestDTO) {
        Post postToUpdate = repository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Post not found for id: %d", id)));
        
        String title = requestDTO.text();
        String text = requestDTO.text();
        String image = requestDTO.image();

        postToUpdate = new Post(id, title, text, image, postToUpdate.getDate());
        
        repository.save(postToUpdate);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
    }

    @Override
    public List<PostResponseDTO> findAll() {
        return super.findAll();
    }

    @Override
    public PostResponseDTO findById(Long id) {
        return super.findById(id);
    }

}
