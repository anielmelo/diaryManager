package br.edu.ifpb.esperanca.ads.diarymanager.diary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.esperanca.ads.diarymanager.diary.dto.PostRequestDTO;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.dto.PostResponseDTO;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.service.PostService;

@RestController
@RequestMapping(path = "post")
public class PostController {
    @Autowired
    PostService serviceImpl;

    @PostMapping("/")
    public ResponseEntity<Void> create(@RequestBody PostRequestDTO postRequestDTO) {
        serviceImpl.create(postRequestDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Void> update(@PathVariable Long postId, @RequestBody PostRequestDTO postRequestDTO) {
        serviceImpl.update(postId, postRequestDTO);
        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> delete(@PathVariable Long postId) {
        serviceImpl.delete(postId);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/{postId}")
    public ResponseEntity<PostResponseDTO> getById(@PathVariable Long postId) {
        PostResponseDTO postResponseDTO = serviceImpl.findById(postId);
        return ResponseEntity.ok().body(postResponseDTO);
    }
    
    @GetMapping("/")
    public ResponseEntity<List<PostResponseDTO>> getAll() {
        List<PostResponseDTO> postResponseDTOs = serviceImpl.findAll();
        return ResponseEntity.ok().body(postResponseDTOs);
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<PostResponseDTO>> findAllPaged(Pageable pageable) {
        Page<PostResponseDTO> page = serviceImpl.findAllPaged(pageable);
        return ResponseEntity.ok().body(page);
    }
}
