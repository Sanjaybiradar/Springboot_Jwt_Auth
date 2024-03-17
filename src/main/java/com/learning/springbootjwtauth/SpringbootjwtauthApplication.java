package com.learning.springbootjwtauth;

import com.learning.springbootjwtauth.entity.User;
import com.learning.springbootjwtauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringbootjwtauthApplication {
	@Autowired
	private UserRepository repository;
	@PostConstruct
	public void initUsers() {
		List<User> users = Stream.of(
				new User(101, "aravind", "password1","aravi.45@gmail.com"),
				new User(102, "vinay", "pass1","vini23@gmail.com"),
				new User(103, "ravi", "pwd1","rockingravi@gmail.com")
		).collect(Collectors.toList());
		repository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootjwtauthApplication.class, args);
	}

}
