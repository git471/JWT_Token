package com.vikas.jwt;

import com.vikas.jwt.entity.User;
import com.vikas.jwt.repository.Userepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class JwtApplication {
	@Autowired
	Userepository userepository;
	@PostConstruct
	public void initusers(){
		List<User> users = Stream.of(
			new User(1,"vikas","vikas","vikas@gmail.com"),
			new User(2,"vinod","vinod","vinod@gmail.com")
		).toList();
		userepository.saveAll(users);
	}
	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	}

}
