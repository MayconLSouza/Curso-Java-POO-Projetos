package com.mayconlsouza.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mayconlsouza.workshopmongo.domain.User;
import com.mayconlsouza.workshopmongo.dto.UserDTO;
import com.mayconlsouza.workshopmongo.repository.UserRepository;
import com.mayconlsouza.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll()
    {
        return repository.findAll();
    }

    public User findById(String id)
    {
        return repository.findById(id)
            .orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public User insert(User obj)
    {
        return repository.insert(obj);
    }

    public void delete(String id)
    {
        findById(id);
        repository.deleteById(id);
    }

    public User fromDTO(UserDTO objDTO)
    {
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }
}
