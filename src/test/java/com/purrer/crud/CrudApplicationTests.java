package com.purrer.crud;

import com.purrer.crud.model.Tweet;
import com.purrer.crud.model.User;
import com.purrer.crud.repository.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class CrudApplicationTests {
	@Autowired
	private UserRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	void checkUserByNameTest(){
		User user = repository.findByUsername("Skitty");

		assert user != null;
	}

	@Test
	void countAllUsers(){
		List<User> users = repository.findAll();
		assert repository.findAll().size() == 2;
	}

	@Test
	void countUsersAfterAddingOne(){
		User user = new User("Meow");
		user.setUsername("Skitty");



		repository.save(user);

		assert repository.findAll().size() == 3;
	}

	@Test
	void findUserByNameTest(){
		assert repository.findByUsername("Delcatty") != null;
	}

	@Test
	void userEquality(){
		User user = new User("Lo");
		assert user.getId() == null;
	}
}
