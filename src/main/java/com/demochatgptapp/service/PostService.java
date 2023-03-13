package com.demochatgptapp.service;

import com.demochatgptapp.entity.Post;
import com.demochatgptapp.exception.PostNotFoundException;
import com.demochatgptapp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long id) throws PostNotFoundException {
        Optional<Post> postOptional = postRepository.findById(id);
        if (postOptional.isPresent()) {
            return postOptional.get();
        } else {
            throw new PostNotFoundException("Post not found with ID: " + id);
        }
    }

    public Post createPost(Post post) {
        post.setDateCreated(LocalDateTime.now());
        post.setDateUpdated(LocalDateTime.now());
        return postRepository.save(post);
    }

    public Post updatePost(Long id, Post post) throws PostNotFoundException {
        Optional<Post> postOptional = postRepository.findById(id);
        if (postOptional.isPresent()) {
            Post existingPost = postOptional.get();
            existingPost.setTitle(post.getTitle());
            existingPost.setContent(post.getContent());
            existingPost.setSlug(post.getSlug());
            existingPost.setDateUpdated(LocalDateTime.now());
            return postRepository.save(existingPost);
        } else {
            throw new PostNotFoundException("Post not found with ID: " + id);
        }
    }

    public void deletePost(Long id) throws PostNotFoundException {
        Optional<Post> postOptional = postRepository.findById(id);
        if (postOptional.isPresent()) {
            postRepository.deleteById(id);
        } else {
            throw new PostNotFoundException("Post not found with ID: " + id);
        }
    }
}