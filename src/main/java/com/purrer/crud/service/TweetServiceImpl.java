package com.purrer.crud.service;

import com.purrer.crud.dto.TweetUserDto;
import com.purrer.crud.model.Tweet;
import com.purrer.crud.repository.TweetRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TweetServiceImpl implements TweetService {
    private TweetRepository repository;
    private ModelMapper mapper;

    public TweetServiceImpl(TweetRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Tweet> getAll() {
        return repository.findAll();
    }

    @Override
    public Tweet getById(int id) {
        return repository.getOne(id);
    }

    @Override
    public List<TweetUserDto> getAllWithUsername() {
        List<TweetUserDto> res = repository.findAll()
                .stream()
                .map(this::convertToTweetUserDto)
                .collect(Collectors.toList());
        return res;

    }

    @Override
    public void add(Tweet tweet) {
        tweet.setSetTime(LocalDateTime.now());
        repository.save(tweet);
    }

    @Override
    public void update(Tweet tweet) {
        int id = tweet.getId();
        Optional<Tweet> tweetOptional = repository.findById(id);
        if(tweetOptional.isPresent()){
            Tweet updateTweet = tweetOptional.get();
            updateTweet.setUser(tweet.getUser());
            updateTweet.setText(tweet.getText());
            updateTweet.setSetTime(tweet.getSetTime());
            repository.save(updateTweet);
        }
        repository.save(tweet);
    }

    @Override
    public void delete(Tweet tweet) {
        repository.delete(tweet);
    }

    private TweetUserDto convertToTweetUserDto(Tweet tweet){
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return mapper.map(tweet, TweetUserDto.class);
    }
}
