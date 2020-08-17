package com.laptrinhweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.laptrinhweb.dto.FormRegister;
import com.laptrinhweb.entity.UserEntity;
import com.laptrinhweb.repository.UserRepository;

@Service
public class UserSevice {

	@Autowired()
	private PasswordEncoder encoder;

	
	@Autowired()
	private UserRepository repository;
	public UserEntity register(FormRegister form) {
		UserEntity entity = new UserEntity();
		entity.setEmail(form.getEmail());
		entity.setUsername(form.getUser());
		entity.setPassword(encoder.encode(form.getPass()));
		return repository.save(entity);
	}
}
