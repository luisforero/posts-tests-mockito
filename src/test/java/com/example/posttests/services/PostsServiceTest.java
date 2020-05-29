package com.example.posttests.services;

import com.example.posttests.models.Category;
import com.example.posttests.models.Post;
import com.example.posttests.models.User;
import com.example.posttests.repositories.PostsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PostsServiceTest {
    @Mock
    PostsRepository postsRepositoryMock;

    @Captor
    ArgumentCaptor acString;

    @InjectMocks
    PostsService postsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @DisplayName("Given ")
    @Test
    public void finByObjectIdTest() {
        Post samplePost = Post.builder()
                .id("abc123")
                .body("My body")
                .category(Category.Entertainment)
                .title("Title")
                .user(mock(User.class))
                .views(1)
                .date(Date.from(Instant.now()))
                .build();
        when(postsRepositoryMock.findByObjectId(anyString())).thenReturn(samplePost);
        assertEquals(samplePost, postsService.findByObjectId("abc123"));

        verify(postsRepositoryMock).findByObjectId((String) acString.capture());
        assertEquals("abc123", acString.getValue());
        verify(postsRepositoryMock, atLeastOnce()).findByObjectId(anyString());
    }

}