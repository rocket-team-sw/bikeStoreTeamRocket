package com.RocketbackEndJwt.api.service;

import org.springframework.data.repository.CrudRepository;

import com.RocketbackEndJwt.api.entities.Modelo;

/**
 * Definición de interfaz para la conexión con la tabla modelos
 * @author juanfvasquez
 * 03.Feb.2019
 */
public interface ModeloDAO extends CrudRepository<Modelo, Long>{

}
