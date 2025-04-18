package br.edu.ifpb.esperanca.ads.diarymanager.diary.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface IBaseController<RequestDTO, ResponseDTO, Id> {
    ResponseEntity<List<ResponseDTO>> findAll();

    ResponseEntity<ResponseDTO> findById(Id id);

    ResponseEntity<ResponseDTO> create(RequestDTO dto);

    ResponseEntity<ResponseDTO> update(Id id, RequestDTO dto);

    ResponseEntity<Void> delete(Id id);
}
