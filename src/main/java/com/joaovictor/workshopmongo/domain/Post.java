package com.joaovictor.workshopmongo.domain;

import com.joaovictor.workshopmongo.dto.AuthorDto;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post implements Serializable {
    private static final long serialVersionUIDLONG = 1L;

    @Id
    private String id;
    private Date date;
    private String title;
    private String body;
    private AuthorDto author;

}
