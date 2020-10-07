package com.purrer.crud.controller;

import com.purrer.crud.dto.TweetUserDto;
import com.purrer.crud.model.Tweet;
import com.purrer.crud.repository.TweetRepository;
import com.purrer.crud.service.TweetService;
import com.sun.jndi.toolkit.url.Uri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TweetController {
    @Autowired
    private TweetService service;

    @GetMapping("/tweets")
    List<TweetUserDto> getTweets(){
        return service.getAllWithUsername();
    }

//    @PostMapping("/tweets")
//    ResponseEntity<Tweet> addTweet(@RequestBody Tweet tweet) throws URISyntaxException {
//        service.add(tweet);
//        return ResponseEntity.created(new URI("api/tweets/" + tweet.getId())).body(tweet);
//    }


}
