package com.pedrosouza.workshopmongo.repository;

import com.pedrosouza.workshopmongo.domain.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {
 
    
}