package com.example.demo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Person;
import com.example.demo.jdbc.PersonJdbcDAO;

@SpringBootApplication
public class SpringJdbcApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDAO dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		logger.info("All Users {}",dao.findAll());
		logger.info("get one person {}",dao.findById(100));
		logger.info("Deleting 102 -> Numbers of rows deleted -> {}",dao.deleteById(102));
		logger.info("The new person -> {}",dao.insert(new Person(105,"Maria","Rancagua",new Date())));
		logger.info("the new position of maria",dao.update(new Person(105,"Maria","Santiago",new Date())));
		
	}
}
