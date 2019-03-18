package com.RocketbackEndJwt.api.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.RocketbackEndJwt.api.entities.Usuario;
import com.RocketbackEndJwt.api.security.jwt.JwtUserFactory;
import com.RocketbackEndJwt.api.service.UserDao;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario user = userService.findByEmail(email);
		if (user == null) {
			System.out.println("Error realizando login");
			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", email));
		} else {
			return JwtUserFactory.create(user);
		}
	}

}
