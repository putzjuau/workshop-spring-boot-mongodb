package com.joaovictor.workshopmongo.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Data
@Document
@AllArgsConstructor
public class Users implements Serializable {
    private static final long serialVersionUIDLONG = 1L;

    @Id
    private String id;
    private String name;
    private String email;

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
