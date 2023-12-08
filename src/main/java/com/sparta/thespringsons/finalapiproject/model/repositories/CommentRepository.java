package com.sparta.thespringsons.finalapiproject.model.repositories;

import com.sparta.thespringsons.finalapiproject.model.entities.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
    List<Comment> findAllByName(String name);

    List<Comment> findAllByMovieId(String id);

    List<Comment> findAllById(String id);

    Comment findByMovieId(String id);

    void deleteAllById(String id);

    List<Comment> findAllById(List<String> commentIds);
}
