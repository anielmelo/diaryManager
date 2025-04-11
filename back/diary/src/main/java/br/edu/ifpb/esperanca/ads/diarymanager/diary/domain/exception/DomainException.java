package br.edu.ifpb.esperanca.ads.diarymanager.diary.domain.exception;

public abstract class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }
}
