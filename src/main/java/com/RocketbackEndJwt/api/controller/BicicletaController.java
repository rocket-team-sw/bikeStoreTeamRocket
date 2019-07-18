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

import com.RocketbackEndJwt.api.entities.Bicicleta;
import com.RocketbackEndJwt.api.response.Response;
import com.RocketbackEndJwt.api.response.ResponseCode;
import com.RocketbackEndJwt.api.service.BIcicletaDAO;

/**
 * Clase controladora para las peticiones relacionadas con bicicletas
 * @author juanfvasquez
 */
@RestController
@RequestMapping("api/bicicletas")
@CrossOrigin(origins = "*")
public class BicicletaController {

	@Autowired
	private BIcicletaDAO bicicletaDao;
	
	private Response<Bicicleta> respuesta;
	private Bicicleta emptyObject = new Bicicleta();
	private ArrayList<Bicicleta> emptyList = new ArrayList<>();
	
	/**
	 * Mètodo para crear bicicleta 
	 * @param bicicleta objeto con los datos a crear
	 * @return objeto de la clase Bicicleta creado
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Bicicleta>> create(@RequestBody Bicicleta bicicleta, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			bicicleta.validar();
			bicicletaDao.save(bicicleta);
			respuesta = new Response<>(bicicleta, emptyList, "Ok", ResponseCode.OK_CODE);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error creando Bicicleta. " + e.getMessage(), ResponseCode.ERROR_CODE);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Método para listar todas las bicicletas
	 * @return lista con objetos Bicicleta
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Bicicleta>> list(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Bicicleta> bicicletas = (List<Bicicleta>) bicicletaDao.findAll();
			respuesta = new Response<>(emptyObject, bicicletas, "Ok", ResponseCode.OK_CODE);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error Leyendo bicicletas", ResponseCode.ERROR_CODE);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	/***
	 * Método para consultar los datos de una bicicleta dado un id
	 * @param id identificador de la bicicleta a buscar
	 * @return objeto Bicicleta
	 */
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Bicicleta>> get(@PathVariable Long id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (id == null) {
				throw new Exception("Debe ingresar un id válido");
			}
			Bicicleta bicicleta = bicicletaDao.findById(id).get();
			if (bicicleta == null) {
				throw new Exception("El id no esta registrado");
			}
			respuesta = new Response<>(bicicleta, emptyList, "Ok", ResponseCode.OK_CODE);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error Leyendo bicicleta. " + e.getMessage(), ResponseCode.ERROR_CODE);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Método para actualizar una bicicleta
	 * @param id identificador de la bicicleta a actualizar
	 * @param newBicicleta objeto Bicicleta con los nuevos datos
	 * @return objeto Bicicleta actualizado
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Bicicleta>> update(@PathVariable Long id, @RequestBody Bicicleta newBicicleta, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (id == null) {
				throw new Exception("Debe ingresar un id válido");
			}
			Bicicleta bicicleta = bicicletaDao.findById(id).get();
			if (bicicleta == null) {
				throw new Exception("El id no esta registrado");
			}
			newBicicleta.validar();
			bicicleta.actualizar(newBicicleta);
			respuesta = new Response<>(bicicleta, emptyList, "Ok", ResponseCode.OK_CODE);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error actualizando bicicleta. " + e.getMessage(), ResponseCode.ERROR_CODE);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Método para eliminar una bicicleta
	 * @param id identificador de la bicicleta a eliminar
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Bicicleta>> delete(@PathVariable Long id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (id == null) {
				throw new Exception("Debe ingresar un id válido");
			}
			Bicicleta bicicleta = bicicletaDao.findById(id).get();
			if (bicicleta == null) {
				throw new Exception("El id no esta registrado");
			}
			bicicletaDao.delete(bicicleta);
			respuesta = new Response<>(emptyObject, emptyList, "Ok", ResponseCode.OK_CODE);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error borrando bicicleta. " + e.getMessage(), ResponseCode.ERROR_CODE);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Método para paginar la consulta de las bicicletas
	 * @return lista con objetos Bicicleta
	 */
	@RequestMapping(value = "/paginar/{limit}/{offset}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Bicicleta>> paginar(
			@PathVariable int limit,
			@PathVariable int offset,
			HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Bicicleta> bicicletas = (List<Bicicleta>) bicicletaDao.paginar(limit, offset);
			respuesta = new Response<>(emptyObject, bicicletas, "Ok", ResponseCode.OK_CODE);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error Leyendo bicicletas", ResponseCode.ERROR_CODE);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Método para paginar la búsqueda de las bicicletas
	 * @return lista con objetos Bicicleta
	 */
	@RequestMapping(value = "/buscar/{limit}/{offset}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Bicicleta>> paginarBusqueda(
			@PathVariable String texto,
			@PathVariable int limit,
			@PathVariable int offset,
			HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Bicicleta> bicicletas = (List<Bicicleta>) bicicletaDao.paginarBusqueda(texto, limit, offset);
			respuesta = new Response<>(emptyObject, bicicletas, "Ok", ResponseCode.OK_CODE);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error Leyendo bicicletas", ResponseCode.ERROR_CODE);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
}
