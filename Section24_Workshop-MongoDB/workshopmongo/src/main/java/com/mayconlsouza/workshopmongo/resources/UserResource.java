package com.mayconlsouza.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mayconlsouza.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll()
    {
        User marie = new User("1", "Maria Maroon", "maria@email.com");
        User alex = new User("2", "Alex Azure", "alex@email.com");
        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(marie, alex));
        return ResponseEntity.ok().body(users);
    }

}
