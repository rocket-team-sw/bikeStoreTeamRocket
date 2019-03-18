package com.RocketbackEndJwt.api.repositories;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.RocketbackEndJwt.api.entities.Usuario;

@Transactional
public interface UserRepository extends CrudRepository<Usuario, String> {
	
	Usuario findByEmail(String	email);
	Page<Usuario> findAll(Pageable pageable);
	
}
