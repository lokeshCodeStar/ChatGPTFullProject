/*
package com.demochatgptapp.contoller;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.demochatgptapp.entity.Post;
import com.demochatgptapp.service.PostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private PostService postService;

    @Test
    public void getAllPosts() throws Exception {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(1L, "Title 1", "Content 1", "slug-1", LocalDateTime.now(), LocalDateTime.now()));
        when(postService.getAllPosts()).thenReturn(posts);

        ResultActions result = mockMvc.perform(get("/api/posts").accept(MediaType.APPLICATION_JSON));
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(new Post(1L, "Title 1", "Content 1", "slug-1", LocalDateTime.now(), LocalDateTime.now()));
        result.andExpect(status().isOk())
                .andExpect(content().json(jsonString));
    }

    @Test
    public void getPostById() throws Exception {
        Post post = new Post(1L, "Title 1", "Content 1", "slug-1", LocalDateTime.now(), LocalDateTime.now());

        when(postService.getPostById(anyLong())).thenReturn(Optional.of(post));

        ResultActions result = mockMvc.perform(get("/api/posts/1").accept(MediaType.APPLICATION_JSON));
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(new Post(1L, "Title 1", "Content 1", "slug-1", LocalDateTime.now(), LocalDateTime.now()));
        result.andExpect(status().isOk())
                .andExpect(content().json(jsonString));
    }

    @Test
    public void getPostByIdNotFound() throws Exception {
        when(postService.getPostById(anyLong())).thenReturn(Optional.empty());

        ResultActions result = mockMvc.perform(get("/api/posts/1").accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isNotFound());
    }
}

*/
