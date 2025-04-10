package br.edu.ifpb.esperanca.ads.diarymanager.diary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.esperanca.ads.diarymanager.diary.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {  
} 
