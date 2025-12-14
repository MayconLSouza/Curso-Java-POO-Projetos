package com.mayconlsouza.workshopmongo.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mayconlsouza.workshopmongo.domain.Post;
import com.mayconlsouza.workshopmongo.repository.PostRepository;
import com.mayconlsouza.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id)
    {
        return repository.findById(id)
            .orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public List<Post> findByTitle(String text)
    {
        return repository.findByTitle(text);
    }

    public List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate)
    {
        maxDate.plusDays(1);
        return repository.fullSearch(text, minDate, maxDate);
    }
}
