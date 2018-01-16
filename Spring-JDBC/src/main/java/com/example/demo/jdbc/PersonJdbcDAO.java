package com.example.demo.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Person;

@Repository
public class PersonJdbcDAO {
	
	@Autowired
	JdbcTemplate jdbcTemaplate;
	// Select* from person
	public List<Person> findAll(){
		
		return jdbcTemaplate.query( "Select * from person" , new BeanPropertyRowMapper(Person.class));
		
	}
}
