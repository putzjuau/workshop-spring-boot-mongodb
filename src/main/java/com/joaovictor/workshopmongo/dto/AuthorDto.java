package com.joaovictor.workshopmongo.dto;

import com.joaovictor.workshopmongo.domain.Users;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
@Getter
@Setter
public class AuthorDto implements Serializable{
    private static final long serialVersionUIDLONG = 1L;

    private String id;
    private String name;

    public AuthorDto(){}
    public AuthorDto(Users obj){
        id = obj.getId();
        name = obj.getName();
    }
}
