package com.joaovictor.workshopmongo.config;

import com.joaovictor.workshopmongo.domain.Users;
import com.joaovictor.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        Users maria = new Users(null, "Maria Brown", "maria@gmail.com");
        Users alex = new Users(null, "alex Brown", "alex@gmail.com");
        Users bob = new Users(null, "bob Brown", "bob@gmail.com");


        userRepository.saveAll(Arrays.asList(maria, alex,bob));
    }
}
