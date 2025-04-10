package br.edu.ifpb.esperanca.ads.diarymanager.diary.validator.post;

import br.edu.ifpb.esperanca.ads.diarymanager.diary.validator.IValidator;

public class TitleValidator implements IValidator<String> {

    @Override
    public void validate(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title cannot be null.");
        }

        if (title.length() > 25) {
            throw new IllegalArgumentException("title's length limit: 25 chars.");
        }
    }
}
