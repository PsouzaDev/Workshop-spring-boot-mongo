package com.pedrosouza.workshopmongo.services;

import com.pedrosouza.workshopmongo.domain.Post;
import com.pedrosouza.workshopmongo.repository.PostRepository;
import com.pedrosouza.workshopmongo.services.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserService
 */
@Service
public class PostService {

    @Autowired
    private PostRepository repo;

      public Post findById(String id) {
        var obj = repo.findOne(id);
        if (obj == null)
            throw new ObjectNotFoundException("Objeto não encontrado");
        return obj;
    }
}