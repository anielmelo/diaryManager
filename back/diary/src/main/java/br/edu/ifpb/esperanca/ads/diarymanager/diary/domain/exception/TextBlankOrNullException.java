package br.edu.ifpb.esperanca.ads.diarymanager.diary.domain.exception;

public class TextBlankOrNullException extends DomainException {
    public TextBlankOrNullException() {
        super("Text cannot be null or blank.");
    }
}
