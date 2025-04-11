package br.edu.ifpb.esperanca.ads.diarymanager.diary.validator.post;

import br.edu.ifpb.esperanca.ads.diarymanager.diary.domain.exception.TextBlankOrNullException;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.validator.IValidator;

public class TextValidator implements IValidator<String> {

    @Override
    public void validate(String text) {
        // perhaps
        if (text == null || text.isBlank()) {
            throw new TextBlankOrNullException();
        }
    }
}
