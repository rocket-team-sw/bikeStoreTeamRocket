package com.RocketbackEndJwt.api.service;

import org.springframework.data.repository.CrudRepository;

import com.RocketbackEndJwt.api.entities.Categoria;

public interface CategoriaDAO extends CrudRepository<Categoria, Long> {

}
