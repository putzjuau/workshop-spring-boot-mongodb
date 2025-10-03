package com.joaovictor.workshopmongo.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Document
public class Users implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String name;

    private String email;

    @DBRef(lazy = true)//pega a ref da tabela e o lazzy serve para guardar os usuario
    private List<Post> post = new ArrayList<>();


    public Users(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;

    }
    public Users(){}
}
