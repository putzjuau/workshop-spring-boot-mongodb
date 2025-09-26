package com.joaovictor.workshopmongo.resources;


import com.joaovictor.workshopmongo.domain.User;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User maria = new User("Maria Silva", "1", "maria@gmail.com");
        User alex = new User("alex Silva", "2", "alex@gmail.com");
      List<User> list = new ArrayList<>();
      list.addAll(Arrays.asList(maria, alex));
      return ResponseEntity.ok().body(list);
    }
}
