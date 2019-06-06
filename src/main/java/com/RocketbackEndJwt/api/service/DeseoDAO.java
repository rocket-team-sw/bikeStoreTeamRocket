package com.RocketbackEndJwt.api.service;

import org.springframework.data.repository.CrudRepository;

import com.RocketbackEndJwt.api.entities.Deseo;

/**
 * Definición de interfaz para la conexión con la tabla ventas
 * @author juanfvasquez
 * 03.Feb.2019
 */
public interface DeseoDAO extends CrudRepository<Deseo, Long> {

}
