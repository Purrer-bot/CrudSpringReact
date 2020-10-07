package com.purrer.crud.controller;

import com.purrer.crud.model.User;
import com.purrer.crud.repository.UserRepository;
import com.purrer.crud.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserRepository repository;
    private final UserService service;
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    UserController(UserRepository repository, UserService service){
        this.repository = repository;
        this.service = service;
    }

    @GetMapping("/test")
    ResponseEntity<String> transaction(){
        return new ResponseEntity<>("HI \n", HttpStatus.OK);
    }


    @GetMapping("/user/{user_id}")
    ResponseEntity<User> getUser(@PathVariable Integer user_id){
        Optional<User> user = repository.findById(user_id);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).
                orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/users")
    List<User> getAll(){
        return repository.findAll();
    }

    @PostMapping("/user")
    ResponseEntity<User> createUser(@RequestBody User user) throws URISyntaxException {
        logger.info("USER {}", user);
        User res = repository.save(user);
        return ResponseEntity.created(new URI("/api/user/" + res.getId())).body(res);
    }


    @PutMapping("/user/{id}")
    ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Integer id){
        Optional<User> optionalUser = repository.findById(id);
        if(optionalUser.isPresent()) {
            User updatedUser = optionalUser.get();
            updatedUser.setUsername(user.getUsername());
            updatedUser.setTweets(user.getTweets());
            repository.save(updatedUser);

            return ResponseEntity.ok(updatedUser);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }

    @DeleteMapping("/user/{id}")
    ResponseEntity<?> deleteUser(@PathVariable Integer id){
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
