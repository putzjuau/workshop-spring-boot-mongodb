package com.joaovictor.workshopmongo.repository;

import com.joaovictor.workshopmongo.domain.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<Users, String> {
}

