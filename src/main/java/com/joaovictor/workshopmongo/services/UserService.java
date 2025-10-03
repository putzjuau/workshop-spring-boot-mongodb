package com.joaovictor.workshopmongo.services;

import com.joaovictor.workshopmongo.domain.Users;
import com.joaovictor.workshopmongo.dto.UserDTO;
import com.joaovictor.workshopmongo.exception.ObjectNotFoundException;
import com.joaovictor.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<Users> findAll() {
        return repo.findAll();
    }

    public Users findById(String id) {
        Optional<Users> user = repo.findById(id);
        if (user.isEmpty()) {
            throw new ObjectNotFoundException("Objeto não encontrado ");
        }
        return user.orElse(null);
    }

    public Users insert(Users obj) {
        return repo.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        repo.deleteById(id);

    }

    public Users update(Users obj) {
        Users newObj = repo.findById(obj.getId()).orElseThrow(()-> new ObjectNotFoundException("Usuario não encontrado rapaz!")); // usuario trazido diretamente do bd para atualizacao
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public Users fromDTO(UserDTO objDto) {
        return new Users(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

    public void updateData(Users newObj, Users obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }
}
