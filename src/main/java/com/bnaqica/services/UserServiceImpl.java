package com.bnaqica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bnaqica.dao.UserDao;
import com.bnaqica.models.User;

public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	public void addUser(User user) {
		userDao.addUser(user);
	}

	public void deleteUser(int userId) {
		userDao.deleteUser(userId);

	}

	public void updateUserInfo(User user) {
		userDao.updateUserInfo(user);

	}

	public User getUser(int userId) {
		return userDao.getUser(userId);
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

}
