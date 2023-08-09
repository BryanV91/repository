package com.app.Test.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Test.models.SystemUser;
import com.app.Test.repositories.SystemUserRepository;

@Service
public class SystemUserService {

	@Autowired
	private SystemUserRepository systemUserRepository;

	public List<SystemUser> findAllUsers() {

		return systemUserRepository.findAll();

	}

	public SystemUser saveUser(SystemUser systemUser) {

		Optional<SystemUser> tmp = systemUserRepository.findByCode(systemUser.getCode());

		if (tmp.get() != null) {
			// do nothing.
		} else {
			tmp = Optional.of(new SystemUser());
		}

		tmp.get().setCode(systemUser.getCode());
		tmp.get().setFullName(systemUser.getFullName());
		tmp.get().setMail(systemUser.getMail());
		tmp.get().setStatus(systemUser.getStatus());

		return systemUserRepository.save(tmp.get());

	}

}
