package com.RocketbackEndJwt.api.service;

import org.springframework.data.repository.CrudRepository;

import com.RocketbackEndJwt.api.entities.Promocion;

/**
 * Definición de interfaz para la conexión con la tabla promociones
 * @author juanfvasquez
 * 03.Feb.2019
 */
public interface PromocionDAO extends CrudRepository<Promocion, Long> {

}
