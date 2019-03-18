package com.RocketbackEndJwt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;


import com.RocketbackEndJwt.api.entities.Usuario;
import com.RocketbackEndJwt.api.repositories.UserRepository;
import com.RocketbackEndJwt.enums.ProfileEnum;

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
	CommandLineRunner init(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			initUsers	(userRepository, passwordEncoder);
		};
	}
	
	private void initUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		/*
		User admin = new User();
		Caja caja = new Caja();
		admin.setUserId((long)211);
		admin.setEmail("juanda@gmail.es");
		admin.setPassword(passwordEncoder.encode("12345"));
		admin.setRole("ROLE_ADMIN");
		admin.setNombreCompleto("Juan David Gallego Gomez");
		caja.setIdCaja((long)(1));
		admin.setCaja(caja);
		User find = userRepository.findByEmail("juanda@gmail.es");
		if (find == null) {
			userRepository.save(admin);
		}
		admin.setUserId((long)212);
		admin.setEmail("cris@gmail.es");
		admin.setPassword(passwordEncoder.encode("12345"));
		admin.setRole("ROLE_ADMIN");
		admin.setNombreCompleto("Cristian Eduardo Rodriguez Granada");
		caja.setIdCaja((long)(1));
		admin.setCaja(caja);
		find = userRepository.findByEmail("cris@gmail.es");
		if (find == null) {
			userRepository.save(admin);
		}*/
	}
}
