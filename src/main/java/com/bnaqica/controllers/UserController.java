package com.bnaqica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bnaqica.models.User;
import com.bnaqica.services.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping("/")
	public ModelAndView getMainPage() {
		List<User> allUsers = userService.getAllUsers();
		return new ModelAndView("mainPage", "allUsers", allUsers);
	}

	@RequestMapping("/main")
	public ModelAndView getMainPageRedirect() {
		List<User> allUsers = userService.getAllUsers();
		return new ModelAndView("mainPage", "allUsers", allUsers);
	}

	@RequestMapping("/edit")
	public ModelAndView editUserInfo(@RequestParam int userId,
			@ModelAttribute User user) {
		User userEdited = userService.getUser(userId);
		return new ModelAndView("editUser", "userEdited", userEdited);
	}

	@RequestMapping("/update")
	public ModelAndView updateUserInfo(@ModelAttribute User user) {
		userService.updateUserInfo(user);
		return new ModelAndView("redirect:/main");
	}

	@RequestMapping("/delete")
	public ModelAndView deleteUser(@RequestParam int userId) {
		userService.deleteUser(userId);
		return new ModelAndView("redirect:/main");
	}

	@RequestMapping("/addUser")
	public ModelAndView getAddUserForm(@ModelAttribute User user) {
		return new ModelAndView("addUserForm");
	}

	@RequestMapping("/processAddUser")
	public ModelAndView ProcessAddUser(@ModelAttribute User user) {
		userService.addUser(user);
		return new ModelAndView("redirect:/main");
	}

}
