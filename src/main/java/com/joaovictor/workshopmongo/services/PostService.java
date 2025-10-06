package com.joaovictor.workshopmongo.services;

import com.joaovictor.workshopmongo.domain.Post;
import com.joaovictor.workshopmongo.domain.Users;
import com.joaovictor.workshopmongo.dto.PostDto;
import com.joaovictor.workshopmongo.exception.ObjectNotFoundException;
import com.joaovictor.workshopmongo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository repo;

    public List<Post> findAll() {
        return repo.findAll();
    }

    public Post findById(String id) {
        Optional<Post> post = repo.findById(id);
        if (post.isEmpty()) {
            throw new ObjectNotFoundException("Objeto não encontrado ");
        }
        return post.orElse(null);
    }

    public Post insert(Post obj) {
        return repo.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        repo.deleteById(id);

    }

    public Post update(Post obj) {
        Post newObj = repo.findById(obj.getId()).orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado rapaz!")); // usuario trazido diretamente do bd para atualizacao
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public Post fromDTO(PostDto objDto) {
        return new Post(objDto.getId(), objDto.getDate(), objDto.getTitle(), objDto.getBody(), objDto.getAuthor());
    }

    public void updateData(Post newObj, Post obj) {
        newObj.setDate(obj.getDate());
        newObj.setTitle(obj.getTitle());
        newObj.setBody(obj.getBody());
        newObj.setAuthor(obj.getAuthor());
        newObj.setTitle(obj.getTitle());

    }

    public List<Post> findByTitle(String title) {
     return  repo.searchTitle(title);
    }
}
