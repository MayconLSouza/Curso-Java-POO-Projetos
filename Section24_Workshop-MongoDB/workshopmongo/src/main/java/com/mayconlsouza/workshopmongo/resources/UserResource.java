package com.mayconlsouza.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mayconlsouza.workshopmongo.domain.User;
import com.mayconlsouza.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
    
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll()
    {
        List<User> users = service.findAll();
        return ResponseEntity.ok().body(users);
    }

}
