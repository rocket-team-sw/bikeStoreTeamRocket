package com.RocketbackEndJwt.api.service;

import org.springframework.data.repository.CrudRepository;

import com.RocketbackEndJwt.api.entities.Bicicleta;

/**
 * Definición de interfaz para la conexión con la tabla bicicletas
 * @author juanfvasquez
 * 03.Feb.2019
 */
public interface BIcicletaDAO extends CrudRepository<Bicicleta, Long> {

}
