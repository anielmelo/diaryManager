package br.edu.ifpb.esperanca.ads.diarymanager.diary.domain.exception;

public class TitleLengthException extends DomainException {
    public TitleLengthException() {
        super("Title exceed limit (25 chars).");
    }
}
