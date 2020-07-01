package com.edu.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.model.Subject;

@Repository
public class SubjectDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(Subject subject) {
		final Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(subject);
		session.getTransaction().commit();
		session.close();
	}

	public void update(Subject subject) {
		final Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(subject);
		session.getTransaction().commit();
		session.close();
	}

	public Subject getSubject(int id) {
		final Session session = sessionFactory.openSession();
		final Subject user = (Subject) session.get(Subject.class, id);
		session.close();
		return user;
	}

	public void delete(Subject subject) {
		final Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(subject);
		session.getTransaction().commit();
		session.close();
	}

	public List<Subject> getAll() {
		final Session session = sessionFactory.openSession();
		final List list = session.createCriteria(Subject.class).list();
		session.close();
		return list;
	}
}
