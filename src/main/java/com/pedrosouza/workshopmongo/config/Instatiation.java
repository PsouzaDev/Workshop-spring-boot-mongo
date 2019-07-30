package com.pedrosouza.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import com.pedrosouza.workshopmongo.domain.Post;
import com.pedrosouza.workshopmongo.domain.User;
import com.pedrosouza.workshopmongo.repository.PostRepository;
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

    @Autowired
    private PostRepository postRepository;

   
    public void run(String... arg0) throws Exception {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", maria);
        
        userRepository.save(Arrays.asList(maria, alex, bob));
        postRepository.save(Arrays.asList(post1, post2));
    }
}