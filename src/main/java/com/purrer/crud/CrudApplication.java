package com.purrer.crud;

import com.purrer.crud.model.User;
import com.purrer.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CrudApplication implements CommandLineRunner {
	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

	}
}
