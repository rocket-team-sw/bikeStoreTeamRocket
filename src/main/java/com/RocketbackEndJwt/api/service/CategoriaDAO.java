package com.RocketbackEndJwt.api.service;

import org.springframework.data.repository.CrudRepository;

import com.RocketbackEndJwt.api.entities.Categoria;

/**
 * Definición de interfaz para la conexión con la tabla categorias
 * @author juanfvasquez
 * 03.Feb.2019
 */
public interface CategoriaDAO extends CrudRepository<Categoria, Long> {

}
