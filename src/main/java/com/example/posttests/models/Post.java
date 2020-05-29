package com.example.posttests.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "posts")
public class Post {
    @Id
    private String id;
    private String title, body;
    private Date date;
    private Date lastUpdate;
    private Category category;
    private List<String> tags;
    private User user;
    private Integer views;
    private List<Comment> comments;
}
