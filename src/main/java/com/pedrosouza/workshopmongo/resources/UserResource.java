package com.pedrosouza.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import com.pedrosouza.workshopmongo.domain.User;
import com.pedrosouza.workshopmongo.dto.UserDto;
import com.pedrosouza.workshopmongo.services.UserService;

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
    public ResponseEntity<List<UserDto>> findAll() {
       
        List<User> list = service.findAll();
        List<UserDto> listDto = list.stream().map(user -> new UserDto(user)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
}