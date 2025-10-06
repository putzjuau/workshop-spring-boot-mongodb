package com.joaovictor.workshopmongo.repository;

import com.joaovictor.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByTitleContainingIgnoreCase(String text); // só essa declaracao aqiu ja faz com que o springdata ja faca a consulta para nos dentro do

    @Query("{'title': { $regex: ?0, $options: 'i'} }")
        // aqui dentro colocamos nossa conulta
// ?"0 é o primeiro parametro que vem no metodo, como tem o text, seria ele
// "i" é o case sensitive dentro do @query
    List<Post> searchTitle(String text);
}