/*
package com.demochatgptapp.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.demochatgptapp.entity.Post;
import com.demochatgptapp.exception.PostNotFoundException;
import com.demochatgptapp.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@WebMvcTest(PostService.class)
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class PostServiceTest {
    
    @Mock
    private PostRepository postRepository;
    
    @InjectMocks
    private PostService postService;
    
    private Post post;
    
    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        
        post = new Post();
        post.setId(1L);
        post.setTitle("Test Post");
        post.setContent("This is a test post.");
        post.setSlug("test-post");
        post.setDateCreated(LocalDateTime.now());
        post.setDateUpdated(LocalDateTime.now());
    }
    
    @Test
    void testGetAllPosts() {
        List<Post> expectedPosts = Arrays.asList(post);
        when(postRepository.findAll()).thenReturn(expectedPosts);
        
        List<Post> actualPosts = postService.getAllPosts();
        
        assertEquals(expectedPosts, actualPosts);
        verify(postRepository, times(1)).findAll();
    }
    
    @Test
    void testGetPostById() throws PostNotFoundException {
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        
        Optional<Post> actualPost = Optional.ofNullable(postService.getPostById(1L));
        
        assertTrue(actualPost.isPresent());
        assertEquals(post, actualPost.get());
        verify(postRepository, times(1)).findById(1L);
    }
    
    @Test
    void testCreatePost() {
        when(postRepository.save(any(Post.class))).thenReturn(post);
        
        Post newPost = new Post();
        newPost.setTitle("New Test Post");
        newPost.setContent("This is a new test post.");
        newPost.setSlug("new-test-post");
        
        Post actualPost = postService.createPost(newPost);
        
        assertEquals(post, actualPost);
        assertNotNull(actualPost.getId());
        assertNotNull(actualPost.getDateCreated());
        assertNotNull(actualPost.getDateUpdated());
        verify(postRepository, times(1)).save(newPost);
    }
    
    @Test
    void testUpdatePost() throws PostNotFoundException {
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(postRepository.save(any(Post.class))).thenReturn(post);
        
        Post updatedPost = new Post();
        updatedPost.setTitle("Updated Test Post");
        updatedPost.setContent("This is an updated test post.");
        updatedPost.setSlug("updated-test-post");
        
        Post actualPost = postService.updatePost(1L, updatedPost);
        
        assertEquals(post, actualPost);
        assertEquals(updatedPost.getTitle(), actualPost.getTitle());
        assertEquals(updatedPost.getContent(), actualPost.getContent());
        assertEquals(updatedPost.getSlug(), actualPost.getSlug());
        assertNotNull(actualPost.getDateUpdated());
        verify(postRepository, times(1)).findById(1L);
        verify(postRepository, times(1)).save(post);
    }
    
    @Test
    void testDeletePost() throws PostNotFoundException {
        postService.deletePost(1L);
        
        verify(postRepository, times(1)).deleteById(1L);
    }
}
*/
