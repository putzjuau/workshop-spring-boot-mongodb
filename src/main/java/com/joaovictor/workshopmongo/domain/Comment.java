package com.joaovictor.workshopmongo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment implements Serializable {
    private static final long serialVersionUIDLONG = 1L;
    @Id
    private String id;
    private String text;
    private Date date;
    private Post post;
}
