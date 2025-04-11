package br.edu.ifpb.esperanca.ads.diarymanager.diary.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PostRequestDTO(
    @NotBlank(message = "title cannot be blank.")
    @NotNull(message = "title is required.")
    String title, 
    @NotBlank(message = "text cannot be blank.")
    @NotNull(message = "text is required.")
    String text, 
    @NotBlank(message = "image cannot be blank.")
    @NotNull(message = "image is required.")
    String image) {
}
