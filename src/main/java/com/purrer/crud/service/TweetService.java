package com.purrer.crud.service;

import com.purrer.crud.dto.TweetUserDto;
import com.purrer.crud.model.Tweet;

import java.util.List;

public interface TweetService {
    public List<Tweet> getAll();
    public Tweet getById(int id);
    public List<TweetUserDto> getAllWithUsername();
    public void add(Tweet tweet);
    public void update(Tweet tweet);
    public void delete(Tweet tweet);
}
