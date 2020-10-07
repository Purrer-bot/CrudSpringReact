package com.purrer.crud.repository;

import com.purrer.crud.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Integer> {

    @Query(value = "select Tweets.id, Tweets.text, u.username from Tweets join User u on Tweets.user_id = u.id", nativeQuery = true)
    List<Object> getAllTweetsWithUser();
}
