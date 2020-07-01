package com.edu.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.model.User;

@Repository
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(User user) {
		final Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}

	public void update(User user) {
		final Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();
	}

	public User getUser(String userName) {
		final Session session = sessionFactory.openSession();
		final User user = (User) session.get(User.class, userName);
		session.close();
		return user;
	}

	public void delete(User user) {
		final Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
		session.close();
	}

	public List<User> getAll() {
		final Session session = sessionFactory.openSession();
		final List list = session.createCriteria(User.class).list();
		session.close();
		return list;
	}

	public List<User> getUser(String userName, String password) {
		final Session session = sessionFactory.openSession();
		final String query = "select * from user_table where user_name=:user_name and pwd=:pwd";
		final SQLQuery sqlQuery = session.createSQLQuery(query);
		sqlQuery.setString("user_name", userName);
		sqlQuery.setString("pwd", password);
		final List list = sqlQuery.list();
		session.close();
		return list;
	}

}
