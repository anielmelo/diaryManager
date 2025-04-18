package br.edu.ifpb.esperanca.ads.diarymanager.diary.service.exception;

public class PostNotFoundException extends ServiceException {
    public <ID> PostNotFoundException(ID id) {
        super(String.format("Post not found for id: %d", id));
    }
}
