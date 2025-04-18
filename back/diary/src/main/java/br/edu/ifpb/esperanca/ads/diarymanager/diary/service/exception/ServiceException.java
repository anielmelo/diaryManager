package br.edu.ifpb.esperanca.ads.diarymanager.diary.service.exception;

public abstract class ServiceException extends RuntimeException {
    public ServiceException(String message) {
        super(message);
    }   
}
