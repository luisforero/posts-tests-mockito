package com.example.posttests.repositories;

import com.example.posttests.models.Post;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostsRepository extends CrudRepository<Post, String> {
    @Query("{ '_id': ObjectId( ?0 )}")
    Post findByObjectId(String id);

    @Query("{'title' : {$regex : \".*?0.*\"}}")
    List<Post> findByTitle(String tittle);
}
