package com.mayconlsouza.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mayconlsouza.workshopmongo.domain.User;
import com.mayconlsouza.workshopmongo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll()
    {
        return repository.findAll();
    }
}
