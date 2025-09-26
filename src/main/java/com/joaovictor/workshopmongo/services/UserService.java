package com.joaovictor.workshopmongo.services;

import com.joaovictor.workshopmongo.domain.Users;
import com.joaovictor.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<Users> findAll() {
        return repo.findAll();
    }
}
