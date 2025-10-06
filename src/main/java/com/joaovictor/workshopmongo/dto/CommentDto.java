package com.joaovictor.workshopmongo.dto;

import com.joaovictor.workshopmongo.domain.Comment;
import com.joaovictor.workshopmongo.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.io.Serializable;
import java.util.Date;
@Data

public class CommentDto  {
    private String id;
    private String text;
    private Date date;
    private AuthorDto author;
    private Post post;


    public CommentDto() {
    }

    public CommentDto(String id, String text, Date date, AuthorDto author) {
        this.id = id;
        this.text = text;
        this.date = date;
        this.author = author;
    }

    public CommentDto(Comment comment) {

    }
}
