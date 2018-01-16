package com.example.demo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Person;

@Repository
public class PersonJdbcDAO {
	
	@Autowired
	JdbcTemplate jdbcTemaplate;
	// Select* from person
	
	class PersonRowMapper implements RowMapper<Person>{

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person oPerson = new Person();
			oPerson.setId(rs.getInt("id"));
			oPerson.setLocation(rs.getString("location"));
			oPerson.setName(rs.getString("name"));
			oPerson.setBirthdate(rs.getTimestamp("birthDate"));
			return oPerson;
		}
		
	}
	
	public List<Person> findAll(){
		
		return jdbcTemaplate.query( "Select * from person" , new PersonRowMapper());
		
	}
	
	public Person findById(int id){
			
			return jdbcTemaplate.queryForObject("Select * from person where id = ? ",
					new Object[] {id}, new BeanPropertyRowMapper<Person>(Person.class));
			
	}
	

	public int deleteById(int id){
		
		return jdbcTemaplate.update("delete from person where id = ? ",
				new Object[] {id});
		
	}
	
	public int insert(Person oPerson){
		return jdbcTemaplate.update("insert into person(id,name,location,birthdate) values (?,?,?,?)",
				new Object[] {oPerson.getId(),oPerson.getName(),oPerson.getLocation(),new Timestamp(oPerson.getBirthdate().getTime())});
	}
	
	
	public int update(Person oPerson){
		return jdbcTemaplate.update("update person set name = ?, location = ?, birthDate = ? where id = ?",
				new Object[] {oPerson.getName(),oPerson.getLocation(),new Timestamp(oPerson.getBirthdate().getTime()),oPerson.getId()});
	}
}
