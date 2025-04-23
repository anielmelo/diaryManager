package br.edu.ifpb.esperanca.ads.diarymanager.diary.controller.dtos.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record PostResponseDTO(
        Long id,
        String title,
        String text,
        String image,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime createdAt
) {}
