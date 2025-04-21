package br.edu.ifpb.esperanca.ads.diarymanager.diary.controller;

import java.util.List;
import java.util.stream.Collectors;

import br.edu.ifpb.esperanca.ads.diarymanager.diary.documentation.PostControllerDocs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.esperanca.ads.diarymanager.diary.controller.dtos.request.PostRequestDTO;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.controller.dtos.response.PostResponseDTO;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.domain.Post;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.mapper.IBaseMapper;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.service.IPostService;

@RestController
@RequestMapping("post")
public class PostController implements PostControllerDocs {
    private final IBaseMapper<Post, PostResponseDTO, PostRequestDTO> postMapper;
    private final IPostService postService;
    
    @Autowired
    public PostController(IBaseMapper<Post, PostResponseDTO, PostRequestDTO> postMapper, IPostService postService) {
        this.postMapper = postMapper;
        this.postService = postService;
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<PostResponseDTO> create(@RequestBody PostRequestDTO dto) {
        Post postToCreate = postMapper.toEntity(dto);
        Post postCreated = postService.create(postToCreate);
        PostResponseDTO postResponse = postMapper.toDTO(postCreated);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(postResponse);
    }
    
    @Override
    @GetMapping("/")
    public ResponseEntity<List<PostResponseDTO>> findAll() {
        List<Post> allPosts = postService.findAll();
        List<PostResponseDTO> allPostDtos = allPosts.stream().map(postMapper::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok().body(allPostDtos);
    }

    @Override
    @GetMapping("/paged")
    public ResponseEntity<Page<PostResponseDTO>> findAllPaged(Pageable pageable) {
        Page<Post> posts = postService.findAllPaged(pageable);
        Page<PostResponseDTO> postPages = posts.map(postMapper::toDTO);
        return ResponseEntity.ok().body(postPages);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDTO> findById(@PathVariable Long id) {
        Post post = postService.findById(id);
        PostResponseDTO postResponseDTO = postMapper.toDTO(post);
        return ResponseEntity.ok().body(postResponseDTO);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<PostResponseDTO> update(@PathVariable Long id, @RequestBody PostRequestDTO dto) {
        Post postToUpdate = postMapper.toEntity(dto);
        Post postUpdated = postService.update(id, postToUpdate);
        PostResponseDTO postResponseDTO = postMapper.toDTO(postUpdated);
        return ResponseEntity.ok().body(postResponseDTO);
    }
    
    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
