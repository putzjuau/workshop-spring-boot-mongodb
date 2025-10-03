package com.joaovictor.workshopmongo.repository;

import com.joaovictor.workshopmongo.domain.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
}
