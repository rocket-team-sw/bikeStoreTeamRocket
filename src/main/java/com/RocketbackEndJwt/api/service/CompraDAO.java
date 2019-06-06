package com.RocketbackEndJwt.api.service;

import org.springframework.data.repository.CrudRepository;

import com.RocketbackEndJwt.api.entities.Compra;

/**
 * Definición de interfaz para la conexión con la tabla compras
 * @author juanfvasquez
 * 03.Feb.2019
 */
public interface CompraDAO extends CrudRepository<Compra, Long> {

}
