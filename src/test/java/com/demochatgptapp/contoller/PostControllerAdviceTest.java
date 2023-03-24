/*
package com.demochatgptapp.contoller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.demochatgptapp.controller.PostController;
import com.demochatgptapp.controller.PostControllerAdvice;
import com.demochatgptapp.exception.PostNotFoundException;
import com.demochatgptapp.service.PostService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class PostControllerAdviceTest {

    private MockMvc mockMvc;

    @Mock
    private PostService postService;

    @InjectMocks
    private PostController postController;

    @InjectMocks
    private PostControllerAdvice postControllerAdvice;

    @Test
    void testHandlePostNotFound() throws Exception {
        MockitoAnnotations.openMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(postController)
                .setControllerAdvice(postControllerAdvice)
                .build();

        when(postService.getPostById(1L)).thenThrow(new PostNotFoundException("Post not found"));

        mockMvc.perform(get("/posts/1"))
            .andExpect(status().isNotFound())
            .andExpect(content().contentType(MediaType.valueOf("text/plain;charset=ISO-8859-1")))
            .andExpect(content().string("Post not found"));

        verify(postService, times(1)).getPostById(1L);
    }

    @Test
    void testHandleGenericException() throws Exception {
        RuntimeException exception = new RuntimeException("Internal Server Error");
        ResponseEntity<String> response = postControllerAdvice.handleGenericException(exception);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("An error occurred while processing your request.", response.getBody());
    }
    }
}
*/
