package com.RocketbackEndJwt.api.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.RocketbackEndJwt.api.entities.Bicicleta;

/**
 * Definición de interfaz para la conexión con la tabla bicicletas
 * @author juanfvasquez
 * 03.Feb.2019
 */
public interface BIcicletaDAO extends CrudRepository<Bicicleta, Long> {

	@Query(value ="SELECT * FROM bicicletas LIMIT :limit OFFSET :offset",nativeQuery = true)
	public List<Bicicleta> paginar(int limit, int offset);
	
	@Query(value ="SELECT * FROM bicicletas WHERE LOWER(nombre) LIKE CONCAT('%', :texto, '%') "
			+ "OR LOWER(descripcion) LIKE CONCAT('%', :texto, '%') "
			+ "OR LOWER(referencia) LIKE CONCAT('%', :texto, '%')"
			+ "LIMIT :limit OFFSET :offset",nativeQuery = true)
	public List<Bicicleta> paginarBusqueda(String texto, int limit, int offset);
}
