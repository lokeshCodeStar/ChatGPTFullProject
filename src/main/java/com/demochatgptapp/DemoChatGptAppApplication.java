package com.demochatgptapp;

import com.demochatgptapp.entity.Post;
import com.demochatgptapp.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class DemoChatGptAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoChatGptAppApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PostRepository postRepository) {
        return  args -> {
            // Create a new post object with some dummy data
            Post post = new Post();
            post.setTitle("New Post Title");
            post.setContent("This is the content of the new post");
            post.setSlug("new-post");
            post.setDateCreated(LocalDateTime.now());
            post.setDateUpdated(LocalDateTime.now());
            // Save the new post to the database
            postRepository.save(post);
            System.out.println("New post added with ID: " + post.getId());
        };
    }
}
