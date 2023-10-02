package com.example.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jdk.jfr.Registered;

@Repository
public class StudentDAOImpl implements StudentDAO{

	EntityManager entityManager;

	@Autowired
	public StudentDAOImpl(EntityManager theEntityManager){
		this.entityManager = theEntityManager;
	}
	@Override
	@Transactional
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
	}
	@Override
	public Student findById(Integer id) {
		return entityManager.find(Student.class, id);
	}
	@Override
	public List<Student> findAll() {
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student ORDER BY lastName", Student.class);
		return theQuery.getResultList();
	}

	@Override
	public List<Student> findByLastName(String lastName) {
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student where lastName = :data", Student.class);
		theQuery.setParameter("data", lastName);

		return theQuery.getResultList();
	}

	@Override
	@Transactional
	public void update(Student theStudent) {
		entityManager.merge(theStudent);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Student theStudent = findById(id);
		entityManager.remove(theStudent);
	}

	@Override
	@Transactional
	public int deleteAll() {
		int count = entityManager.createQuery("DELETE from Student").executeUpdate();
		return count;
	}
}
