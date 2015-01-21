package com.bnaqica.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bnaqica.models.User;

@Repository
public class UserDaoImpl implements UserDao {

	private static final long serialVersionUID = -3206861612460309442L;

	@Autowired
	SessionFactory sessionFactory;

	public void addUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(user);
		tx.commit();
		session.close();
	}

	public void deleteUser(int userId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User user = (User) session.load(User.class, userId);
		session.delete(user);
		tx.commit();
		session.close();
	}

	public void updateUserInfo(User user) {
		System.out.println("UserId: " + user.getUserId());
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(user);
		tx.commit();
		session.close();
	}

	public User getUser(int userId) {
		Session session = sessionFactory.openSession();
		User user = (User) session.load(User.class, userId);
		return user;
	}

	public List<User> getAllUsers() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<User> userList = session.createQuery("from User").list();
		session.close();
		return userList;
	}

}
