package com.purrer.crud.service;

import com.purrer.crud.model.User;
import com.purrer.crud.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    private UserRepository repository;
    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public void makeTransaction(){
//        User res = new User();
//        res.setUsername("Canina");
//        repository.save(res);
//        User user = new User();
//        repository.save(user);
    }
}
