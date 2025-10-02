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
import java.util.List;

@RestController
@RequestMapping("/posts")
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
        Post obj = service.
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
        Users obj = service.FromDTO(objDto);
        obj = service.Insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
