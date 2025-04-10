package br.edu.ifpb.esperanca.ads.diarymanager.diary.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import br.edu.ifpb.esperanca.ads.diarymanager.diary.domain.Post;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.dto.PostRequestDTO;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.dto.PostResponseDTO;

@Component
public class PostMapper implements IMapper<Post, PostRequestDTO, PostResponseDTO> {

    @Override
    public Post toEntity(PostRequestDTO dto) {
        String title = dto.title();
        String text = dto.text();
        String image = dto.image();
        LocalDateTime date = LocalDateTime.now();

        Post newPost = new Post(title, text, image, date);
        return newPost;
    }

    @Override
    public PostResponseDTO toDTO(Post entity) {
        Long id = entity.getId();
        String title = entity.getTitle();
        String text = entity.getText();
        String image = entity.getImage();
        LocalDateTime date = entity.getDate();

        PostResponseDTO responseDTO = new PostResponseDTO(id, title, text, image, date);
        return responseDTO;
    }
    
}
