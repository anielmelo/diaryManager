package br.edu.ifpb.esperanca.ads.diarymanager.diary.domain;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.time.LocalDateTime;

import br.edu.ifpb.esperanca.ads.diarymanager.diary.domain.exception.BlankOrNullException;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.domain.exception.ImageUrlInvalidException;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.domain.exception.TitleLengthException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String text;
    
    @Column(nullable = false)
    private String image;
    
    @Column(nullable = false)
    private LocalDateTime createdAt;
    
    public Post(Long id, String title, String text, String image, LocalDateTime createdAt) {
        validatePost(title, text, image);
        
        this.id = id;
        this.title = title;
        this.text = text;
        this.image = image;
        this.createdAt = createdAt;
    }
    
    public Post(String title, String text, String image) {
        validatePost(title, text, image);
        
        this.title = title;
        this.text = text;
        this.image = image;
        this.createdAt = LocalDateTime.now();
    }

    public Post() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getImage() {
        return image;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    private void validatePost(String title, String text, String image) {
        if (title == null || title.isBlank()) {
            throw new BlankOrNullException("title cannot be null or blank.");
        }
        
        if (text == null || text.isBlank()) {
            throw new BlankOrNullException("text cannot be null or blank.");
        }
        
        if (image == null || image.isBlank()) {
            throw new BlankOrNullException("image cannot be null or blank.");
        }
        
        if (title.length() > 25) {
            throw new TitleLengthException("title length cannot be over 25 chars.");
        }

        if (!validateImageUrl(image)) {
            throw new ImageUrlInvalidException("image url invalid.");
        }
    }

    private boolean validateImageUrl(String image) {
        try {
            URL url = new URI(image).toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(3000);
            connection.connect();

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
