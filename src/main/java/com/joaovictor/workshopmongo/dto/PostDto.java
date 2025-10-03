package com.joaovictor.workshopmongo.dto;

import com.joaovictor.workshopmongo.domain.Post;
import com.joaovictor.workshopmongo.domain.Users;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class PostDto implements Serializable {

    private String id;
    private Date date;
    private String title;
    private String body;
    private AuthorDto author;

    public PostDto(){}

    public PostDto(Post obj){
        id = obj.getId();
        date = obj.getDate();
        title = obj.getTitle();
        body = obj.getBody();
        author = obj.getAuthor();
    }
}
