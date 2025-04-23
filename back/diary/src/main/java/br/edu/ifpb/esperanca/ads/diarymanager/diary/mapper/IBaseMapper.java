package br.edu.ifpb.esperanca.ads.diarymanager.diary.mapper;

public interface IBaseMapper<Entity, ResponseDTO, RequestDTO> {
    ResponseDTO toDTO(Entity entity);

    Entity toEntity(RequestDTO dto);
}
