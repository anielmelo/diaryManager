package br.edu.ifpb.esperanca.ads.diarymanager.diary.service;

import org.springframework.stereotype.Service;

import br.edu.ifpb.esperanca.ads.diarymanager.diary.domain.Post;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.dto.PostRequestDTO;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.dto.PostResponseDTO;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.mapper.PostMapper;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.repository.PostRepository;

@Service
public class PostService extends BaseService<PostRequestDTO, PostResponseDTO, Post, Long> {

    public PostService(PostRepository repository, PostMapper mapper) {
        super(repository, mapper);
    }
}
