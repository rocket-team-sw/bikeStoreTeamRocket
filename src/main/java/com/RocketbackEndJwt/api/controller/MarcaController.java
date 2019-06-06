package com.RocketbackEndJwt.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.RocketbackEndJwt.api.entities.Categoria;
import com.RocketbackEndJwt.api.entities.Marca;
import com.RocketbackEndJwt.api.response.Response;
import com.RocketbackEndJwt.api.response.ResponseCode;
import com.RocketbackEndJwt.api.service.MarcaDAO;

/**
 * Clase controladora para las peticiones relacionadas con marcas
 * @author juanfvasquez
 * 
 */
@RestController
@RequestMapping("api/marcas")
@CrossOrigin(origins = "*")
public class MarcaController {

	@Autowired
	private MarcaDAO dao;
	
	private Response<Marca> respuesta;
	private Marca emptyObject = new Marca();
	private ArrayList<Marca> emptyList = new ArrayList<>();
	
	/**
	 * Método para crear una marca
	 * @param marca objeto Marca con los datos a crear
	 * @return objeto Marca creado
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Marca>> create(@RequestBody Marca marca, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			marca.validar();
			dao.save(marca);
			respuesta = new Response<>(marca, emptyList, "Ok", ResponseCode.OK_CODE);
			return new ResponseEntity<Response<Marca>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error creando marcas. " + e.getMessage(), ResponseCode.ERROR_CODE);
			return new ResponseEntity<Response<Marca>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Método para listar las marcas
	 * @return lista de objetos Marca
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Marca>> list(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Marca> marcas = (List<Marca>) dao.findAll();
			respuesta = new Response<>(emptyObject, marcas, "Ok", ResponseCode.OK_CODE);
			return new ResponseEntity<Response<Marca>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error Leyendo marcas", ResponseCode.ERROR_CODE);
			return new ResponseEntity<Response<Marca>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Método para buscar una marca dado su id
	 * @param id identificador de una marca
	 * @return objeto Marca 
	 */
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Marca>> get(@PathVariable Long id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (id == null) {
				throw new Exception("Debe ingresar un id válido");
			}
			Marca marca = dao.findById(id).get();
			if (marca == null) {
				throw new Exception("El id no esta registrado");
			}
			respuesta = new Response<>(marca, emptyList, "Ok", ResponseCode.OK_CODE);
			return new ResponseEntity<Response<Marca>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error Leyendo marca." + e.getMessage(), ResponseCode.ERROR_CODE);
			return new ResponseEntity<Response<Marca>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Método para actualizar una marca
	 * @param id identificador de la marca a actualizar
	 * @param newMarca objeto Marca con los datos nuevos
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Marca>> update(@PathVariable Long id, @RequestBody Marca newMarca, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (id == null) {
				throw new Exception("Debe ingresar un id válido");
			}
			Marca marca = dao.findById(id).get();
			if (marca == null) {
				throw new Exception("El id no esta registrado");
			}
			newMarca.validar();
			marca.actualizar(newMarca);
			respuesta = new Response<>(emptyObject, emptyList, "Ok", ResponseCode.OK_CODE);
			return new ResponseEntity<Response<Marca>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error actualizando marca. " + e.getMessage(), ResponseCode.ERROR_CODE);
			return new ResponseEntity<Response<Marca>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Método para eliminar una marca
	 * @param id identificador de una marca
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Marca>> delete(@PathVariable Long id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (id == null) {
				throw new Exception("Debe ingresar un id válido");
			}
			Marca marca = dao.findById(id).get();
			if (marca == null) {
				throw new Exception("El id no esta registrado");
			}
			dao.delete(marca);
			respuesta = new Response<>(emptyObject, emptyList, "Ok", ResponseCode.OK_CODE);
			return new ResponseEntity<Response<Marca>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error borrando marca." + e.getMessage(), ResponseCode.ERROR_CODE);
			return new ResponseEntity<Response<Marca>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
}
