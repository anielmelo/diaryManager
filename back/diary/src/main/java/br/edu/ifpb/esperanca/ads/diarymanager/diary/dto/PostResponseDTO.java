package br.edu.ifpb.esperanca.ads.diarymanager.diary.dto;

import java.time.LocalDateTime;

public record PostResponseDTO(Long id, String title, String text, String image, LocalDateTime date) {
}
