package br.edu.ifpb.esperanca.ads.diarymanager.diary.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.swing.text.html.parser.Entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.esperanca.ads.diarymanager.diary.mapper.IMapper;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.service.exception.PostNotFoundException;

public abstract class BaseService<RequestDTO, ResponseDTO, Entity, ID> implements IService<RequestDTO, ResponseDTO, ID> {

    protected final JpaRepository<Entity, ID> repository;
    protected final IMapper<Entity, RequestDTO, ResponseDTO> mapper;

    protected BaseService(JpaRepository<Entity, ID> repository, IMapper<Entity, RequestDTO, ResponseDTO> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void create(RequestDTO requestDTO) {
        Entity newEntity = mapper.toEntity(requestDTO);
        repository.save(newEntity);
    }

    @Override
    public void update(ID id, RequestDTO requestDTO) {
        Entity entityOld = repository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
        Entity entityNew = mapper.updateFromDTO(requestDTO, entityOld);
        repository.save(entityNew);
    }

    @Override
    public void delete(ID id) {
        Entity entity = repository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
        repository.delete(entity);
    }
    
    @Override
    public List<ResponseDTO> findAll() {
        List<Entity> entities = repository.findAll();
        return entities.stream().map(mapper::toDTO).collect(Collectors.toList());
    }
    
    @Override
    public ResponseDTO findById(ID id) {
        Entity entity = repository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
        ResponseDTO responseDTO = mapper.toDTO(entity);
        return responseDTO;
    }

    @Override
    public Page<ResponseDTO> findAllPaged(Pageable pageable) {
        Page<Entity> page = repository.findAll(pageable);
        return page.map(mapper::toDTO);
    }

}
