package com.RocketbackEndJwt.api.security.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.RocketbackEndJwt.api.entities.Usuario;
import com.RocketbackEndJwt.enums.ProfileEnum;

public class JwtUserFactory {

	private JwtUserFactory() {

	}

	public static JwtUser create(Usuario user) {
		return new JwtUser(user.getUserId(), user.getEmail(), user.getPassword(),
				mapToGrantedAuthorities(user.getRole()));
	}

	private static List<GrantedAuthority> mapToGrantedAuthorities(String profileEnum) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(profileEnum));
		return authorities;
	}

}
