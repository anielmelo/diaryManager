package br.edu.ifpb.esperanca.ads.diarymanager.diary.controller.dtos.request;

public record PostRequestDTO(
        String title,
        String text,
        String image
) {}

