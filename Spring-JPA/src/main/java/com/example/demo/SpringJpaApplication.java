package com.example.demo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Person;
import com.example.demo.respository.PersonJPARepository;

@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJPARepository repo;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("User id 1 -> {}",repo.insert(new Person("Luis","Santiago",new Date())));
		logger.info("User id 1 -> {}",repo.findByid(1));
		Person res = repo.findByid(1);
		res.setLocation("Quilpue");
		logger.info("User id 1 -> {}",repo.update(res));
		logger.info("User id 1 -> {}",repo.findByid(1));
		logger.info("Users - {}", repo.findAll() );
		repo.delete(1);
	}
}
