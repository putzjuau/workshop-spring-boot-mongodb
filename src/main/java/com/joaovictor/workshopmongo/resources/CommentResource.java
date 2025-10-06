package com.joaovictor.workshopmongo.resources;

import com.joaovictor.workshopmongo.domain.Comment;
import com.joaovictor.workshopmongo.dto.CommentDto;
import com.joaovictor.workshopmongo.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentResource {
    @Autowired
    private CommentService service;
    @GetMapping
    public ResponseEntity<List<CommentDto>> findAll() {
        List<Comment> list = service.findAll();
        List<CommentDto> listDTO = list.stream().map(CommentDto::new).toList();
        return ResponseEntity.ok().body(listDTO);
    }
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody CommentDto objDto){
        Comment obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build(); // como não tem que conter nada, chamamos o nocontent
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> insert(@RequestBody CommentDto objDto, @PathVariable String id) {
        Comment obj = service.fromDTO(objDto);
        obj.setId(id); //garantindo que o obj tera o id da requisicão
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

}
