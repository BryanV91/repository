package com.app.Test.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Test.models.SystemUser;
import com.app.Test.services.SystemUserService;

@RestController
@RequestMapping("/users")
public class SystemUserController {

	@Autowired
	private SystemUserService systemUserService;

	@GetMapping("/all")
	public List<SystemUser> findUsers() {
		return systemUserService.findAllUsers();
	}

	@PostMapping("/manage")
	public SystemUser saveUser(@RequestBody SystemUser systemUser) {
		return systemUserService.saveUser(systemUser);
	}

}
