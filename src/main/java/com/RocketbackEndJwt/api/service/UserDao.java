package com.RocketbackEndJwt.api.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.RocketbackEndJwt.api.entities.Usuario;

/**
 * Definición de interfaz para la conexión con la tabla usuarios
 * @author juanfvasquez
 * 03.Feb.2019
 */
@Transactional
public interface UserDao extends CrudRepository<Usuario, Long> {

	public Usuario  findByUserName(String username);
    public Usuario  findByUserId(String id);
    public Usuario  findByEmail(String email);
    public List<Usuario>  findByRole(String rol);
  
  	
}
