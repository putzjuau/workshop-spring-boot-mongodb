package com.joaovictor.workshopmongo.services;

import com.joaovictor.workshopmongo.domain.Post;
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

    public void findById(String id) {
        Optional<Post> post = repo.findById(id);
        if (post.isEmpty()) {
            throw new ObjectNotFoundException("Objeto não encontrado ");
        }
    }

    public Post Insert(Post obj) {
        return repo.insert(obj);
    }

    public void Delete(String id) {
        findById(id);
        repo.deleteById(id);

    }

//    public Post update(Post obj) {
//        Post newObj = repo.findById(obj.getId()).orElseThrow(()-> new ObjectNotFoundException("Usuario não encontrado rapaz!")); // usuario trazido diretamente do bd para atualizacao
//        updateData(newObj, obj);
//        return repo.save(newObj);
//    }

//    public Post FromDTO(Post objDto) {
//        return new Post(objDto.getId(), SimpleDateFormat.paobjDto.getTitle(), objDto.getDate(), objDto.getBody());
//    }

//    public void updateData(Post newObj, Post obj) {
//        newObj.setName(obj.getName());
//        newObj.setEmail(obj.getEmail());
//    }
}
