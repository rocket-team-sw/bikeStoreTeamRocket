package com.RocketbackEndJwt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;


import com.RocketbackEndJwt.api.entities.Usuario;
import com.RocketbackEndJwt.api.service.UserDao;

@SpringBootApplication
public class BackEndJwtBikeStoreApplication extends SpringBootServletInitializer {

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BackEndJwtBikeStoreApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(BackEndJwtBikeStoreApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(UserDao userDao, PasswordEncoder passwordEncoder) {
		return args -> {
			initUser(userDao, passwordEncoder);
		};
	}
	
	private void initUser(UserDao userDao, PasswordEncoder passwordEncoder) {
		Usuario admin = new Usuario();
		admin.setEmail("admin@mail.com");
		admin.setPassword(passwordEncoder.encode("123456"));
		admin.setRole("ROLE_SUPER");
		admin.setUserName("Admin");
		admin.setApellidos("Admin");
		
		if (userDao.findByEmail("admin@mail.com") == null) {
			userDao.save(admin);
		}
	}
}
