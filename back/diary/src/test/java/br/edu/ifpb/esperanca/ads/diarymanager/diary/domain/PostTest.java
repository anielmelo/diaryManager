package br.edu.ifpb.esperanca.ads.diarymanager.diary.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import br.edu.ifpb.esperanca.ads.diarymanager.diary.domain.exception.BlankOrNullException;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.domain.exception.ImageUrlInvalidException;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.domain.exception.TitleLengthException;

public class PostTest {
    
    private static final String VALID_IMAGE = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fauditeste.com.br%2Ftestes-manuais%2F&psig=AOvVaw0TMmYWOSmcTcW-YGwzrn8K&ust=1745008446140000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCICb5Jj134wDFQAAAAAdAAAAABAE";

    @Test
    void shouldCreatePostWithValidData() {
        String title = "Valid Title";
        String text = "Some valid content.";

        Post post = new Post(title, text, VALID_IMAGE);

        assertEquals(title, post.getTitle());
        assertEquals(text, post.getText());
        assertEquals(VALID_IMAGE, post.getImage());
        assertNotNull(post.getCreatedAt());
    }

    @Test
    void shouldThrowExceptionWhenTitleIsNull() {
        BlankOrNullException ex = assertThrows(BlankOrNullException.class, () -> {
            new Post(null, "Text", VALID_IMAGE);
        });

        assertEquals("title cannot be null or blank.", ex.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenTitleIsBlank() {
        BlankOrNullException ex = assertThrows(BlankOrNullException.class, () -> {
            new Post("   ", "Text", VALID_IMAGE);
        });

        assertEquals("title cannot be null or blank.", ex.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenTitleIsTooLong() {
        String longTitle = "This title is way too long to be accepted";

        TitleLengthException ex = assertThrows(TitleLengthException.class, () -> {
            new Post(longTitle, "Text", VALID_IMAGE);
        });

        assertEquals("title length cannot be over 25 chars.", ex.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenTextIsNull() {
        BlankOrNullException ex = assertThrows(BlankOrNullException.class, () -> {
            new Post("Title", null, VALID_IMAGE);
        });

        assertEquals("text cannot be null or blank.", ex.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenTextIsBlank() {
        BlankOrNullException ex = assertThrows(BlankOrNullException.class, () -> {
            new Post("Title", "   ", VALID_IMAGE);
        });

        assertEquals("text cannot be null or blank.", ex.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenImageIsNull() {
        BlankOrNullException ex = assertThrows(BlankOrNullException.class, () -> {
            new Post("Title", "Text", null);
        });

        assertEquals("image cannot be null or blank.", ex.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenImageIsBlank() {
        BlankOrNullException ex = assertThrows(BlankOrNullException.class, () -> {
            new Post("Title", "Text", "   ");
        });

        assertEquals("image cannot be null or blank.", ex.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenImageUrlIsInvalid() {
        String invalidImage = "invalid-url";

        ImageUrlInvalidException ex = assertThrows(ImageUrlInvalidException.class, () -> {
            new Post("Title", "Text", invalidImage);
        });

        assertEquals("image url invalid.", ex.getMessage());
    }

    @Test
    void shouldCreatePostWithAllFields() {
        Long id = 1L;
        String title = "Title";
        String text = "Content";
        String image = VALID_IMAGE;
        LocalDateTime createdAt = LocalDateTime.now();

        Post post = new Post(id, title, text, image, createdAt);

        assertEquals(id, post.getId());
        assertEquals(title, post.getTitle());
        assertEquals(text, post.getText());
        assertEquals(image, post.getImage());
        assertEquals(createdAt, post.getCreatedAt());
    }
}
