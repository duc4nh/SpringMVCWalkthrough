package com.fdmgroup.springmvcwalkthrough.springcontroller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.springmvcwalkthrough.PasswordValidator;
import com.fdmgroup.springmvcwalkthrough.User;
import com.fdmgroup.springmvcwalkthrough.UserFactory;

@Controller
public class RegistrationController {

	@Resource
	private PasswordValidator validator;
	@Resource
	private UserFactory userFactory;

	// This controller is an abstraction layer on top of a servlet

	// Normally, we would need doGet and/or doPost, we dont in Sping MVC
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registrationRedirect(Model model) {
		model.addAttribute("user", userFactory.create());
		return "registrationPage";
	}

	// @RequestMapping(value = "/registerDetails", method = RequestMethod.POST)
	// public String registrationUser(Model model, @RequestParam("username")
	// String username, @RequestParam("password") String password,
	// @RequestParam("confpassword") String confpassword) {
	//
	// if (validator.check(password, confpassword)) {
	// model.addAttribute("username", username);
	// return "registrationConfirm";
	// }
	//
	// return "registrationPage";
	// }

	// Capture user details using Spring form
	@RequestMapping(value = "/registerDetails", method = RequestMethod.POST)
	public String registrationUser(Model model, User user, @RequestParam("confpassword") String confpassword) {

		if (validator.check(user.getPassword(), confpassword)) {
			model.addAttribute("username", user.getUsername());
			return "registrationConfirm";
		}

		return "registrationPage";
	}
}
