package com.pedrosouza.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.pedrosouza.workshopmongo.domain.User;
import com.pedrosouza.workshopmongo.dto.UserDto;
import com.pedrosouza.workshopmongo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    @RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
    public ResponseEntity<UserDto> findById(@PathVariable String id) {
        var user = service.findById(id);
        return ResponseEntity.ok().body(new UserDto(user));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody UserDto objDto) {
        User obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); 
        return ResponseEntity.created(uri).build();
    }
}