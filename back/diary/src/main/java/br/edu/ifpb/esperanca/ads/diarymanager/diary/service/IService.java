package br.edu.ifpb.esperanca.ads.diarymanager.diary.service;

import java.util.List;

public interface IService<RequestDTO, RepsonseDTO, ID> {
    void create(RequestDTO requestDTO);
    List<RepsonseDTO> findAll();
    RepsonseDTO findById(ID id);
    void update(ID id, RequestDTO requestDTO);
    void delete(ID id);
}
