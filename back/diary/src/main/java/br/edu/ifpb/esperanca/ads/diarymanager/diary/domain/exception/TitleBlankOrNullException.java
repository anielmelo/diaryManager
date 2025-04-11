package br.edu.ifpb.esperanca.ads.diarymanager.diary.domain.exception;

public class TitleBlankOrNullException extends DomainException {
    public TitleBlankOrNullException() {
        super("Title cannot be null or blank.");
    }
}
