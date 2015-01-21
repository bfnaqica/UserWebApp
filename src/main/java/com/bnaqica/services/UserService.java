package com.bnaqica.services;

import java.util.List;

import com.bnaqica.models.User;

public interface UserService {
	public void addUser(User user);

	public void deleteUser(int userId);

	public void updateUserInfo(User user);

	public User getUser(int userId);

	public List<User> getAllUsers();

}
