package com.joaovictor.workshopmongo.domain;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class User implements Serializable {
    private static final long serialVersionUid = 1L;
    private String id;
    private String name;
    private String email;


    public User() {

    }

    public User(String name, String id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

}
