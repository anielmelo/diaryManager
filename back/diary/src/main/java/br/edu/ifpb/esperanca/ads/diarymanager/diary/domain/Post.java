package br.edu.ifpb.esperanca.ads.diarymanager.diary.domain;

import java.time.LocalDateTime;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false)
    private String text;
    
    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private LocalDateTime date;
    
    public Post(Long id, String title, String text, String image, LocalDateTime date) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.image = image;
        this.date = date;
    }
    
    public Post(String title, String text, String image, LocalDateTime date) {
        this.title = title;
        this.text = text;
        this.image = image;
        this.date = date;
    }
    
    public Post() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
