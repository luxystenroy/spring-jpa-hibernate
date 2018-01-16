package com.example.demo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Person;


@Repository
@Transactional
public class PersonJPARepository {

	// connect to the database
	@PersistenceContext
	EntityManager entityManager;


	public Person findById(int id) {
		return entityManager.find(Person.class, id);// JPA
	}

	

}