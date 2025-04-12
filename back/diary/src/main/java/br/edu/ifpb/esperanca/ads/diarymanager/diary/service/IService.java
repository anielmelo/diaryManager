package br.edu.ifpb.esperanca.ads.diarymanager.diary.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IService<RequestDTO, RepsonseDTO, ID> {
    void create(RequestDTO requestDTO);
    List<RepsonseDTO> findAll();
    RepsonseDTO findById(ID id);
    Page<RepsonseDTO> findAllPaged(Pageable pageable);
    void update(ID id, RequestDTO requestDTO);
    void delete(ID id);
}
