package com.RocketbackEndJwt.api.service;

import org.springframework.data.repository.CrudRepository;

import com.RocketbackEndJwt.api.entities.Cliente;

public interface ClienteDAO extends CrudRepository<Cliente, Long> {

}
