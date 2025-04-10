package br.edu.ifpb.esperanca.ads.diarymanager.diary.validator.post;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import br.edu.ifpb.esperanca.ads.diarymanager.diary.validator.IValidator;

public class ImageValidator implements IValidator<String> {

    @Override
    public void validate(String type) {
        try {
            URL url = new URI(type).toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(3000);
            connection.connect();

            return;
        } catch (Exception e) {
            throw new IllegalArgumentException("image URL invalid.");
        }
    }
}
