package br.edu.ifpb.esperanca.ads.diarymanager.diary.documentation;

import br.edu.ifpb.esperanca.ads.diarymanager.diary.controller.IBaseController;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.controller.dtos.request.PostRequestDTO;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.controller.dtos.response.PostResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Posts", description = "Operações relacionadas ao gerenciamento de posts")
public interface PostControllerDocs extends IBaseController<PostRequestDTO, PostResponseDTO, Long> {

    @Operation(
            summary = "Listar todos os posts",
            description = "Retorna uma lista contendo todos os posts cadastrados no sistema.",
            tags = {"Read"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de posts retornada com sucesso")
    })
    ResponseEntity<List<PostResponseDTO>> findAll();

    @Operation(
            summary = "Buscar post por ID",
            description = "Retorna os detalhes de um post específico com base no seu ID.",
            tags = {"Read"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Post encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Post não encontrado para o ID informado")
    })
    ResponseEntity<PostResponseDTO> findById(
            @Parameter(description = "ID do post a ser buscado", required = true) Long id);

    @Operation(
            summary = "Criar um novo post",
            description = "Cadastra um novo post no sistema com as informações fornecidas.",
            tags = {"Create"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Post criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para criação do post")
    })
    ResponseEntity<PostResponseDTO> create(
            @Parameter(description = "Dados do post a ser criado", required = true) PostRequestDTO dto);

    @Operation(
            summary = "Atualizar um post existente",
            description = "Atualiza as informações de um post previamente cadastrado.",
            tags = {"Update"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Post atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para atualização"),
            @ApiResponse(responseCode = "404", description = "Post não encontrado para o ID informado")
    })
    ResponseEntity<PostResponseDTO> update(
            @Parameter(description = "ID do post a ser atualizado", required = true) Long id,
            @Parameter(description = "Dados atualizados do post", required = true) PostRequestDTO dto);

    @Operation(
            summary = "Excluir um post",
            description = "Remove permanentemente um post do sistema com base no seu ID.",
            tags = {"Delete"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Post excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Post não encontrado para o ID informado")
    })
    ResponseEntity<Void> delete(
            @Parameter(description = "ID do post a ser excluído", required = true) Long id);
}
