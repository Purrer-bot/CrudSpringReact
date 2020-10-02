package com.purrer.crud.repository;

import com.purrer.crud.model.Tweet;
import com.purrer.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
//
//    @Transactional(timeout = 3)
//    @Override
//    <S extends User> S save(S s);
}
