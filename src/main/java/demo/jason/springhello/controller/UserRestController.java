package demo.jason.springhello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.jason.springhello.entity.User;

@RestController
public class UserRestController {

	@RequestMapping(
			value = "/user",
			method = RequestMethod.GET
	)
	public User getCurrentUser() {
		return null;
	}
}
