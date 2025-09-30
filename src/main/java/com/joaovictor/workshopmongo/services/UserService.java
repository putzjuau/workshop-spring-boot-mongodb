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
    public Users findById(String id){
       Optional<Users> user = repo.findById(id);
       if(user.isEmpty()){
           throw  new ObjectNotFoundException("Objeto não encontrado ");
       }
       return user.orElse(null);
    }
    public Users Insert(Users obj){
        return repo.insert(obj);
    }
    public Users FromDTO(UserDTO objDto){
        return new Users(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
