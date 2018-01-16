package com.example.demo.respository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Person;

@Repository
@Transactional
public class PersonJPARepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	
	public Person findByid(int i) {
		
		return entityManager.find(Person.class, i);
		
	}
	
	public Person insert(Person person) {
		
		return entityManager.merge(person);
	}
	
	public Person update(Person person) {
		
		return entityManager.merge(person);
	}
	
	public void delete(int id) {
		Person person = findByid(id);
		entityManager.remove(person);
	}
	
	public List<Person> findAll(){
		
		TypedQuery<Person> namedQuery = (TypedQuery<Person>) entityManager.createNamedQuery("find_all_person");
		return namedQuery.getResultList();
	}
	
	
	
}
