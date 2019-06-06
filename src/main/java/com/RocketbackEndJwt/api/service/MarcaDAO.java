package com.RocketbackEndJwt.api.service;

import org.springframework.data.repository.CrudRepository;

import com.RocketbackEndJwt.api.entities.Marca;

/**
 * Definición de interfaz para la conexión con la tabla marcas
 * @author juanfvasquez
 * 03.Feb.2019
 */
public interface MarcaDAO extends CrudRepository<Marca, Long> {

}
