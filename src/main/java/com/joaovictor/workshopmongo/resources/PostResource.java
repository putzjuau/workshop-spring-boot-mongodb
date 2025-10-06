package com.joaovictor.workshopmongo.resources;

import com.joaovictor.workshopmongo.domain.Post;
import com.joaovictor.workshopmongo.domain.Users;
import com.joaovictor.workshopmongo.dto.PostDto;
import com.joaovictor.workshopmongo.dto.UserDTO;
import com.joaovictor.workshopmongo.services.PostService;
import com.joaovictor.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = {"/posts", "/posts/"})
public class PostResource {
    @Autowired
    private PostService service;

    @GetMapping
    public ResponseEntity<List<PostDto>> findAll() {
        List<Post> list = service.findAll();
        List<PostDto> listDTO = list.stream().map(PostDto::new).toList();
        return ResponseEntity.ok().body(listDTO);
    }
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody PostDto objDto){
        Post obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(Collections.singletonList(obj)); // como não tem que conter nada, chamamos o nocontent
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build(); // como não tem que conter nada, chamamos o nocontent
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> insert(@RequestBody PostDto objDto, @PathVariable String id) {
        Post obj = service.fromDTO(objDto);
        obj.setId(id); //garantindo que o obj tera o id da requisicão
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }


}
