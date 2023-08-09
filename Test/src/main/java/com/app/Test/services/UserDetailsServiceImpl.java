package com.app.Test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.Test.models.SystemUser;
import com.app.Test.repositories.SystemUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private SystemUserRepository systemUserRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SystemUser user = systemUserRepository.findByCode(username)
				.orElseThrow(() -> new UsernameNotFoundException("Code not found: " + username));
		return UserDetailsImpl.build(user);
	}

}
