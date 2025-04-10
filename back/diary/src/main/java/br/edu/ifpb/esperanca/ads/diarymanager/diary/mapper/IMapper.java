package br.edu.ifpb.esperanca.ads.diarymanager.diary.mapper;

public interface IMapper<Entity, RequestDTO, ResponseDTO> {
    Entity toEntity(RequestDTO dto);
    ResponseDTO toDTO(Entity entity);
}
