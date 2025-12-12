package com.mayconlsouza.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mayconlsouza.workshopmongo.domain.User;
import com.mayconlsouza.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception 
    {
        userRepository.deleteAll();;

        User maria = new User(null, "Maria Maroon", "maria@gmail.com");
        User alex = new User(null, "Alex Azure", "alex@gmail.com");
        User bob = new User(null, "Bob Brown", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(maria, alex, bob));
    }

}
