package com.edu.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.model.Student;

@Repository
public class StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(Student student) throws Exception {
		Session session = null;
		Transaction beginTransaction = null;
		try {
			session = sessionFactory.openSession();
			beginTransaction = session.beginTransaction();
			session.save(student);
			beginTransaction.commit();
		} catch (final Exception e) {
			if (beginTransaction != null) {
				beginTransaction.rollback();
			}
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void update(Student student) throws Exception {
		Session session = null;
		Transaction beginTransaction = null;
		try {
			session = sessionFactory.openSession();
			beginTransaction = session.beginTransaction();
			session.update(student);
			beginTransaction.commit();
		} catch (final Exception e) {
			if (beginTransaction != null) {
				beginTransaction.rollback();
			}
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Student getStudent(int id) {
		final Session session = sessionFactory.openSession();
		final Student user = (Student) session.get(Student.class, id);
		session.close();
		return user;
	}

	public void delete(Student student) throws Exception {
		Transaction beginTransaction = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			beginTransaction = session.beginTransaction();
			session.delete(student);
			beginTransaction.commit();
		} catch (final Exception e) {
			if (beginTransaction != null) {
				beginTransaction.rollback();
			}
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public List<Student> getAll() {
		final Session session = sessionFactory.openSession();
		final List list = session.createCriteria(Student.class).list();
		session.close();
		return list;
	}

	public List<Student> search(String name) {
		final Session session = sessionFactory.openSession();
		final Criteria createCriteria = session.createCriteria(Student.class);
		createCriteria.add(Restrictions.eqOrIsNull("name", name));
		final List list = createCriteria.list();
		session.close();
		return list;
	}

	public List orderByName(boolean asc) {
		final Session session = sessionFactory.openSession();
		final Criteria createCriteria = session.createCriteria(Student.class);
		if (asc) {
			createCriteria.addOrder(Order.asc("name"));
		} else {
			createCriteria.addOrder(Order.desc("name"));
		}
		final List list = createCriteria.list();
		session.close();
		return list;
	}
}
