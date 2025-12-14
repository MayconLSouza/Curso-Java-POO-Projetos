package com.mayconlsouza.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.mayconlsouza.workshopmongo.domain.Post;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> findByTitle(String title);

    @Query("{ $and: [ {date: { $gte: ?1 } }, {date: { $lte: ?2 } }, { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate);

    List<Post> findByTitleContainingIgnoreCase(String title);
}
