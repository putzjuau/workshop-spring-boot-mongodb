package com.joaovictor.workshopmongo.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Document
public class Users implements Serializable {
    private static final long serialVersionUid = 1L;
    @Id

    private String id;
    private String name;
    private String email;


    public Users() {

    }

    public Users( String id,String name, String email) {

        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Users user)) return false;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

}
