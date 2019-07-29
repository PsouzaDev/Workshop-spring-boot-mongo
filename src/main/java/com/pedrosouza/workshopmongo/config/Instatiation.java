package com.pedrosouza.workshopmongo.config;

import java.util.Arrays;

import com.pedrosouza.workshopmongo.domain.User;
import com.pedrosouza.workshopmongo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 * Instatiation
 */
@Configuration
public class Instatiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

   
    public void run(String... arg0) throws Exception {
        
        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        
        userRepository.save(Arrays.asList(maria, alex, bob));
    }
}