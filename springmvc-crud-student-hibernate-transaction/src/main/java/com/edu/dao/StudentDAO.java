package com.edu.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.edu.model.Student;

@Repository
public class StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(rollbackFor = Exception.class)
	public void save(Student student) {
		final Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		session.close();
	}

	@Transactional(rollbackFor = Exception.class)
	public void update(Student student) {
		final Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(student);
		session.getTransaction().commit();
		session.close();
	}

	public Student getStudent(int id) {
		final Session session = sessionFactory.openSession();
		final Student user = (Student) session.get(Student.class, id);
		session.close();
		return user;
	}

	public void delete(Student user) {
		final Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
		session.close();
	}

	public List<Student> getAll() {
		final Session session = sessionFactory.openSession();
		final List list = session.createCriteria(Student.class).list();
		session.close();
		return list;
	}
}
