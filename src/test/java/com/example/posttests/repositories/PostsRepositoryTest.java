package com.example.posttests.repositories;

import com.example.posttests.models.Category;
import com.example.posttests.models.Post;
import com.example.posttests.models.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@DataMongoTest
class PostsRepositoryTest {
    @DisplayName("Given object to save" +
            " When save object using MongoDB CRUD Repository" +
            " Then object is saved")
    @Test
    public void Test(@Autowired PostsRepository postsRepository) {
        Post samplePost = Post.builder()
                .body("My body")
                .title("Title")
                .category(Category.Entertainment)
                .user(User.builder()
                        .name("Luwi")
                        .status("Status")
                        .build())
                .views(1)
                .date(Date.from(Instant.now()))
                .build();

        postsRepository.save(samplePost);

        assertTrue(postsRepository.count() > 0);
    }
}