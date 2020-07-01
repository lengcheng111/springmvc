package com.edu.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.edu.model.Student;

@Repository
@Service
public class StudentDAO {

	private static final int DEFAULT_MAX_RESULT = 20;
	// @Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

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

	// public List<Student> getAll() {
	// final Session session = sessionFactory.openSession();
	// final List list = session.createCriteria(Student.class).list();
	// session.close();
	// return list;
	// }

	@SuppressWarnings("unchecked")
	public List<Student> getAll(Integer offset, Integer maxResults) {
		return sessionFactory.openSession().createCriteria(Student.class).setFirstResult(offset != null ? offset : 0)
				.setMaxResults(maxResults != null ? maxResults : DEFAULT_MAX_RESULT).list();
	}

	public List<Student> search(String name) {
		final Session session = sessionFactory.openSession();
		final Criteria createCriteria = session.createCriteria(Student.class);
		createCriteria.add(Restrictions.eqOrIsNull("name", name));
		final List list = createCriteria.list();
		session.close();
		return list;
	}

	public int countStudent() {
		final Session session = sessionFactory.openSession();
		final String hql = "select count(1) from Student";
		final Long total = (Long) session.createQuery(hql).uniqueResult();
		session.close();
		return total.intValue();
	}

	public List orderByColumnName(boolean asc, String columName, Integer offset, Integer maxResults) {
		final Session session = sessionFactory.openSession();
		final Criteria createCriteria = buildCreteriaForOrdering(asc, columName, session);
		createCriteria.setFirstResult(offset != null ? offset : 0)
				.setMaxResults(maxResults != null ? maxResults : DEFAULT_MAX_RESULT);
		final List list = createCriteria.list();
		session.close();
		return list;
	}

	public List orderByName(boolean asc, String columName) {
		final Session session = sessionFactory.openSession();
		final Criteria createCriteria = buildCreteriaForOrdering(asc, columName, session);
		final List list = createCriteria.list();
		session.close();
		return list;
	}

	private Criteria buildCreteriaForOrdering(boolean asc, String columName, final Session session) {
		final Criteria createCriteria = session.createCriteria(Student.class);
		if (asc) {
			createCriteria.addOrder(Order.asc(columName));
		} else {
			createCriteria.addOrder(Order.desc(columName));
		}
		return createCriteria;
	}
}
