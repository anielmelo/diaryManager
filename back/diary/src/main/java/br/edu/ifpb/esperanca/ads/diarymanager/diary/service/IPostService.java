package br.edu.ifpb.esperanca.ads.diarymanager.diary.service;

import br.edu.ifpb.esperanca.ads.diarymanager.diary.domain.Post;

import java.util.List;

public interface IPostService {
    List<Post> findAll();
    Post findById(Long id);
    Post create(Post post);
    Post update(Long id, Post post);
    void delete(Long id);
}
