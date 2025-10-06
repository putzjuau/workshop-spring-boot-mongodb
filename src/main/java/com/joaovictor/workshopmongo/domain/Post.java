package com.joaovictor.workshopmongo.domain;

import com.joaovictor.workshopmongo.dto.AuthorDto;
import com.joaovictor.workshopmongo.dto.CommentDto;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data

public class Post implements Serializable {
    private static final long serialVersionUIDLONG = 1L;

    @Id
    private String id;
    private Date date;
    private String title;
    private String body;
    private AuthorDto author;

    private List<CommentDto> comments = new ArrayList<>();

    public Post() {
    }

    public Post(String id, Date date, String title, String body, AuthorDto author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }
}
