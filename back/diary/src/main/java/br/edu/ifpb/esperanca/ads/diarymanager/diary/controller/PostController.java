package br.edu.ifpb.esperanca.ads.diarymanager.diary.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.esperanca.ads.diarymanager.diary.controller.dtos.request.PostRequestDTO;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.controller.dtos.response.PostResponseDTO;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.domain.Post;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.mapper.IBaseMapper;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.service.IPostService;

@RestController
@RequestMapping("post")
public class PostController implements IBaseController<PostRequestDTO, PostResponseDTO, Long> {
    private final IBaseMapper<Post, PostResponseDTO, PostRequestDTO> postMapper;
    private final IPostService postService;
    
    public PostController(IBaseMapper<Post, PostResponseDTO, PostRequestDTO> postMapper, IPostService postService) {
        this.postMapper = postMapper;
        this.postService = postService;
    }

    @Override
    public ResponseEntity<PostResponseDTO> create(PostRequestDTO dto) {
        Post postToCreate = postMapper.toEntity(dto);
        Post postCreated = postService.create(postToCreate);
        PostResponseDTO postResponse = postMapper.toDTO(postCreated);
        
        return ResponseEntity.ok().body(postResponse);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        postService.delete(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<PostResponseDTO>> findAll() {
        List<Post> allPosts = postService.findAll();
        List<PostResponseDTO> allPostDtos = allPosts.stream().map(postMapper::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok().body(allPostDtos);
    }

    @Override
    public ResponseEntity<PostResponseDTO> findById(Long id) {
        Post post = postService.findById(id);
        PostResponseDTO postResponseDTO = postMapper.toDTO(post);
        return ResponseEntity.ok().body(postResponseDTO);
    }

    @Override
    public ResponseEntity<PostResponseDTO> update(Long id, PostRequestDTO dto) {
        Post postToUpdate = postMapper.toEntity(dto);
        Post postUpdated = postService.update(id, postToUpdate);
        PostResponseDTO postResponseDTO = postMapper.toDTO(postUpdated);
        return ResponseEntity.ok().body(postResponseDTO);
    }
}
