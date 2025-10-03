package com.joaovictor.workshopmongo.dto;

import com.joaovictor.workshopmongo.domain.Comment;
import com.joaovictor.workshopmongo.domain.Post;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
public class CommentDto implements Serializable {
    private static final long serialVersionUIDLONG = 1L;
    private String id;
    private String text;
    private Date date;
    private Post post;

    public CommentDto() {
    }

    public CommentDto(Comment obj) {
        id = obj.getId();
        text = obj.getText();
        date = obj.getDate();
        post = obj.getPost();
    }
}
