package br.edu.ifpb.esperanca.ads.diarymanager.diary.validator.post;

import br.edu.ifpb.esperanca.ads.diarymanager.diary.domain.exception.TitleBlankOrNullException;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.domain.exception.TitleLengthException;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.validator.IValidator;

public class TitleValidator implements IValidator<String> {

    @Override
    public void validate(String title) {
        if (title == null || title.isBlank()) {
            throw new TitleBlankOrNullException();
        }

        if (title.length() > 25) {
            throw new TitleLengthException();
        }
    }
}
