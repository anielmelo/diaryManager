package br.edu.ifpb.esperanca.ads.diarymanager.diary.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface IBaseController<RequestDTO, ResponseDTO, Id> {
    ResponseEntity<ResponseDTO> create(RequestDTO dto);

    ResponseEntity<List<ResponseDTO>> findAll();

    ResponseEntity<Page<ResponseDTO>> findAllPaged(Pageable pageable);

    ResponseEntity<ResponseDTO> findById(Id id);

    ResponseEntity<ResponseDTO> update(Id id, RequestDTO dto);

    ResponseEntity<Void> delete(Id id);
}
