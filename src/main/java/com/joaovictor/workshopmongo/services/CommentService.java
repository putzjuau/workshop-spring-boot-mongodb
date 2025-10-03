package com.joaovictor.workshopmongo.services;

import com.joaovictor.workshopmongo.domain.Comment;
import com.joaovictor.workshopmongo.domain.Post;
import com.joaovictor.workshopmongo.dto.CommentDto;
import com.joaovictor.workshopmongo.dto.PostDto;
import com.joaovictor.workshopmongo.exception.ObjectNotFoundException;
import com.joaovictor.workshopmongo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CommentService {
    @Autowired
    private CommentRepository repo;

    public List<Comment> findAll() {
        return repo.findAll();
    }

    public void findById(String id) {
        Optional<Comment> comment = repo.findById(id);
        if (comment.isEmpty()) {
            throw new ObjectNotFoundException("Comentário não encotrado meu querido, sinto muito!");

        }
    }

    public Comment insert(Comment obj) {
        return repo.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        repo.deleteById(id);

    }

    public Comment update(Comment obj) {
        Comment newObj = repo.findById(obj.getId()).orElseThrow(() -> new ObjectNotFoundException("Comentário não encontrado"));
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public Comment fromDTO(CommentDto objDto) {
        return new Comment(objDto.getId(),  objDto.getText(),objDto.getDate(), objDto.getPost());
    }

    public void updateData(Comment newObj, Comment obj) {
        newObj.setDate(obj.getDate());
        newObj.setText(obj.getText());
        newObj.setPost(obj.getPost());

    }
}
