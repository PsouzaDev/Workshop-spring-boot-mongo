package com.pedrosouza.workshopmongo.resources;

import java.util.List;

import com.pedrosouza.workshopmongo.UserService;
import com.pedrosouza.workshopmongo.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserResource
 */
@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
       
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}