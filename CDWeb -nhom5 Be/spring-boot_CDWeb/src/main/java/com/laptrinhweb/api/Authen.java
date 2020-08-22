package com.laptrinhweb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhweb.config.JwtTokenProvider;
import com.laptrinhweb.config.ResponJWT;
import com.laptrinhweb.dto.FormLogin;
import com.laptrinhweb.dto.FormRegister;
import com.laptrinhweb.entity.UserEntity;
import com.laptrinhweb.service.impl.UserSevice;

@RestController()
@CrossOrigin
public class Authen {

	@Autowired()
	private UserSevice service;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider tokenProwireder;

	@PostMapping(value = "/authen/login")
	private ResponJWT login(@RequestBody FormLogin login) {
		System.out.println(login);
		Authentication authen = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(login.getUser(), login.getPass()));
		SecurityContextHolder.getContext().setAuthentication(authen);
		String jwt = tokenProwireder.generateToken((UserDetails) authen.getPrincipal());
	return new ResponJWT(jwt);
	}
	
	@PostMapping(value = "/authen/register")
	private UserEntity register(@RequestBody() FormRegister register) {
		System.out.println("s");
		return service.register(register);
	}

}
