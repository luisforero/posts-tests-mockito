package com.example.posttests.services;

import com.example.posttests.models.Post;
import com.example.posttests.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsService {

    final
    PostsRepository postsRepository;

    @Autowired
    public PostsService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    public Post findByObjectId(String id) {
        return postsRepository.findByObjectId(id);
    }

    public List<Post> findByTitle(String tittle) {
        return postsRepository.findByTitle(tittle);
    }
}
