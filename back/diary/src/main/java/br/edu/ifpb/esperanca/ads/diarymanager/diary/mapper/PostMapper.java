package br.edu.ifpb.esperanca.ads.diarymanager.diary.mapper;

import br.edu.ifpb.esperanca.ads.diarymanager.diary.controller.dtos.request.PostRequestDTO;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.controller.dtos.response.PostResponseDTO;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.domain.Post;
import org.springframework.stereotype.Component;

@Component
public class PostMapper implements IBaseMapper<Post, PostResponseDTO, PostRequestDTO>{
    @Override
    public PostResponseDTO toDTO(Post post) {
        return new PostResponseDTO(post.getId(), post.getTitle(), post.getText(), post.getImage(), post.getCreatedAt());
    }

    @Override
    public Post toEntity(PostRequestDTO postRequestDTO) {
        return new Post(postRequestDTO.title(), postRequestDTO.text(), postRequestDTO.image());
    }
}
