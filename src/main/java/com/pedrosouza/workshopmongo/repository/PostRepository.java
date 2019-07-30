package com.pedrosouza.workshopmongo.repository;

import com.pedrosouza.workshopmongo.domain.Post;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * PostRepository
 */
@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}