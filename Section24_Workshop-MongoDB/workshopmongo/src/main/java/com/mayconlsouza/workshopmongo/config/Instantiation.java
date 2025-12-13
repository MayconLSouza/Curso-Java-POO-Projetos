package com.mayconlsouza.workshopmongo.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mayconlsouza.workshopmongo.domain.Post;
import com.mayconlsouza.workshopmongo.domain.User;
import com.mayconlsouza.workshopmongo.dto.AuthorDTO;
import com.mayconlsouza.workshopmongo.dto.CommentDTO;
import com.mayconlsouza.workshopmongo.repository.PostRepository;
import com.mayconlsouza.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception 
    {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        userRepository.deleteAll();;
        User maria = new User(null, "Maria Maroon", "maria@gmail.com");
        User alex = new User(null, "Alex Azure", "alex@gmail.com");
        User bob = new User(null, "Bob Brown", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        postRepository.deleteAll();
        Post post1 = new Post(null, LocalDate.parse("21/03/2025", fmt), "Partiu viagem", "Vou viajar para São Paulo, Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, LocalDate.parse("23/03/2025", fmt), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        CommentDTO comment1 = new CommentDTO("Boa viagem mano!", LocalDate.parse("21/03/2025", fmt), new AuthorDTO(alex));
        CommentDTO comment2 = new CommentDTO("Aproveite", LocalDate.parse("22/03/2025", fmt), new AuthorDTO(bob));
        CommentDTO comment3 = new CommentDTO("Tenha um ótimo dia!", LocalDate.parse("23/03/2025", fmt), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(comment1, comment2));
        post2.getComments().add(comment3);
        
        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }

}
