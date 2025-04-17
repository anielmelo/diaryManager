package br.edu.ifpb.esperanca.ads.diarymanager.diary.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PostTest {

    private static final String VALID_IMAGE = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fauditeste.com.br%2Ftestes-manuais%2F&psig=AOvVaw0TMmYWOSmcTcW-YGwzrn8K&ust=1745008446140000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCICb5Jj134wDFQAAAAAdAAAAABAE";

    @Test
    void validCreate() {
        String title = "Titulo Válido";
        String text = "Texto de exemplo";

        Post post = new Post(title, text, VALID_IMAGE);

        assertEquals(title, post.getTitle());
        assertEquals(text, post.getText());
        assertEquals(VALID_IMAGE, post.getImage());
        assertNotNull(post.getCreatedAt());
    }

    @Test
    void titleNullException() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            new Post(null, "Texto", VALID_IMAGE);
        });

        assertEquals("title cannot be null.", ex.getMessage());
    }

    @Test
    void titleBlankException() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            new Post("   ", "Texto", VALID_IMAGE);
        });

        assertEquals("title cannot be null.", ex.getMessage());
    }

    @Test
    void titleLengthException() {
        String longTitle = "Este título é muito grande e ultrapassa o limite permitido.";

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            new Post(longTitle, "Texto", VALID_IMAGE);
        });

        assertEquals("title length cannot be over 25 chars.", ex.getMessage());
    }

    @Test
    void textNullException() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            new Post("Título", null, VALID_IMAGE);
        });

        assertEquals("text cannot be null.", ex.getMessage());
    }

    @Test
    void textBlankException() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            new Post("Título", "   ", VALID_IMAGE);
        });

        assertEquals("text cannot be null.", ex.getMessage());
    }

    @Test
    void imageInvalidException() {
        String imagemInvalida = "https://invalido.exemplo/naoexiste.png";

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            new Post("Título", "Texto", imagemInvalida);
        });

        assertEquals("image url invalid.", ex.getMessage());
    }

    @Test
    void urlInvalidException() {
        String imagemNaoUrl = "não-é-uma-url";

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            new Post("Título", "Texto", imagemNaoUrl);
        });

        assertEquals("image url invalid.", ex.getMessage());
    }
}
