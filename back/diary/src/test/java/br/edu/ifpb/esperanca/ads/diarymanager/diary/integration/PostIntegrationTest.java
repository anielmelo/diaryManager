package br.edu.ifpb.esperanca.ads.diarymanager.diary.integration;

import br.edu.ifpb.esperanca.ads.diarymanager.diary.controller.dtos.request.PostRequestDTO;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.controller.dtos.response.PostResponseDTO;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.domain.Post;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.repository.PostRepository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private PostRepository postRepository;

    private String baseUrl;

    private final String VALID_IMAGE = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fauditeste.com.br%2Ftestes-manuais%2F&psig=AOvVaw0TMmYWOSmcTcW-YGwzrn8K&ust=1745008446140000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCICb5Jj134wDFQAAAAAdAAAAABAE";

    private Post post;

    @BeforeEach
    void setup() {
        postRepository.deleteAll();
        this.baseUrl = "http://localhost:" + port + "/post/";

        post = new Post("Sample Post", "This is a sample post.", VALID_IMAGE);
    }

    @BeforeEach
    void clean() {
        postRepository.deleteAll();
    }

    @Test
    void testCreatePost() {
        PostRequestDTO dto = new PostRequestDTO("My Post", "Some text.", VALID_IMAGE);

        HttpEntity<PostRequestDTO> request = new HttpEntity<>(dto);
        ResponseEntity<PostResponseDTO> response = testRestTemplate
                .exchange(baseUrl, HttpMethod.POST, request, PostResponseDTO.class);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("My Post", response.getBody().title());
    }

    @Test
    void testGetAllPosts() {
        postRepository.save(post);

        ResponseEntity<PostResponseDTO[]> response = testRestTemplate
                .exchange(baseUrl, HttpMethod.GET, null, PostResponseDTO[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().length >= 1);
    }

    @Test
    void testGetPostById() {
        Post savedPost = postRepository.save(post);

        ResponseEntity<PostResponseDTO> response = testRestTemplate
                .exchange(baseUrl + savedPost.getId(), HttpMethod.GET, null, PostResponseDTO.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Sample Post", response.getBody().title());
    }

    @Test
    void testUpdatePost() {
        Post savedPost = postRepository.save(post);

        PostRequestDTO dto = new PostRequestDTO("Updated Title", "Updated text.", VALID_IMAGE);

        HttpEntity<PostRequestDTO> request = new HttpEntity<>(dto);

        ResponseEntity<PostResponseDTO> response = testRestTemplate
                .exchange(baseUrl + savedPost.getId(), HttpMethod.PUT, request, PostResponseDTO.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Updated Title", response.getBody().title());
    }

    @Test
    void testDeletePost() {
        Post savedPost = postRepository.save(post);

        ResponseEntity<Void> response = testRestTemplate
                .exchange(baseUrl + savedPost.getId(), HttpMethod.DELETE, null, Void.class);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertFalse(postRepository.findById(savedPost.getId()).isPresent());
    }

    @Test
    void testGetPostByIdNotFound() {
        Long nonExistentId = 9999L;

        ResponseEntity<String> response = testRestTemplate
                .exchange(baseUrl + nonExistentId, HttpMethod.GET, null, String.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        assertNotNull(response.getBody());
        assertTrue(response.getBody().contains("Post not found for id: " + nonExistentId));
    }
}
