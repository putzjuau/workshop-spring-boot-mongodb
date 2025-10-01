package com.joaovictor.workshopmongo.resources;


import com.joaovictor.workshopmongo.domain.Users;
import com.joaovictor.workshopmongo.dto.UserDTO;
import com.joaovictor.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<Users> list = service.findAll();
        List<UserDTO> listDTO = list.stream().map(UserDTO::new).toList();
        return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        Users obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
        Users obj = service.FromDTO(objDto);
        obj = service.Insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.Delete(id);
        return ResponseEntity.noContent().build(); // como não tem que conter nada, chamamos o nocontent
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto, @PathVariable String id) {
        Users obj = service.FromDTO(objDto);
        obj.setId(id); //garantindo que o obj tera o id da requisicão
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }
}
