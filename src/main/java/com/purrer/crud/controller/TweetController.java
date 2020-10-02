package com.purrer.crud.controller;

import com.purrer.crud.model.Tweet;
import com.purrer.crud.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(("/api"))
public class TweetController {
    @Autowired
    private TweetRepository repository;

    @GetMapping("/tweets")
    List<Tweet> getTweets(){
        return repository.findAll();
    }
}
