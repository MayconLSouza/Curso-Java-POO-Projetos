package com.mayconlsouza.workshopmongo.services;

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
}
