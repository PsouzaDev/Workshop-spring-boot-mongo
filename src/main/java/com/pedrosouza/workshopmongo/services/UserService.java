package com.pedrosouza.workshopmongo.services;

import java.util.List;

import com.pedrosouza.workshopmongo.domain.User;
import com.pedrosouza.workshopmongo.repository.UserRepository;
import com.pedrosouza.workshopmongo.services.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserService
 */
@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll(); 
    }

    public User findById(String id) {
        var user = repo.findOne(id);
        if (user == null)
            throw new ObjectNotFoundException("Objeto não encontrado");
        return user;
    }
}