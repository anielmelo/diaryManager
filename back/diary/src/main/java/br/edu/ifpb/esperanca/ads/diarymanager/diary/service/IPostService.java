package br.edu.ifpb.esperanca.ads.diarymanager.diary.service;

import br.edu.ifpb.esperanca.ads.diarymanager.diary.domain.Post;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPostService {
    List<Post> findAll();

    Page<Post> findAllPaged(Pageable pageable);

    Post findById(Long id);

    Post create(Post post);

    Post update(Long id, Post post);

    void delete(Long id);
}
