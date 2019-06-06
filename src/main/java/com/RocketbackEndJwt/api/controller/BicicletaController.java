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

	/**
	 * bicicletaDao declaracion de Data access Object para la conexion con la Bd
	 */
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
			validate(bicicleta);
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
				error("Debe ingresar un id válido");
			}
			Bicicleta bicicleta = bicicletaDao.findById(id).get();
			if (bicicleta == null) {
				error("El id no esta registrado");
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
				error("Debe ingresar un id válido");
			}
			Bicicleta bicicleta = bicicletaDao.findById(id).get();
			if (bicicleta == null) {
				error("El id no esta registrado");
			}
			bicicleta.setReferencia(newBicicleta.getReferencia());
			bicicleta.setNombre(newBicicleta.getNombre());
			bicicleta.setDescripcion(newBicicleta.getDescripcion());
			bicicleta.setPrecio(newBicicleta.getPrecio());
			bicicleta.setUsada(newBicicleta.isUsada());
			bicicleta.setFecha_borrado(newBicicleta.getFecha_borrado());
			bicicleta.setCategoria(newBicicleta.getCategoria());
			bicicleta.setModelo(newBicicleta.getModelo());
			bicicleta.setMarca(newBicicleta.getMarca());
			
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
				error("Debe ingresar un id válido");
			}
			Bicicleta bicicleta = bicicletaDao.findById(id).get();
			if (bicicleta == null) {
				error("El id no esta registrado");
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
	 * Método para validar los datos de una bicicleta antes de crear o actualizar
	 * @param bicicleta objeto Bicicleta con los datos a validar
	 * @throws Exception Lanzada si se encuentra que algún dato no es válido
	 */
	private void validate(Bicicleta bicicleta) throws Exception {
		if (bicicleta.getReferencia() == null) {
			error("Debe ingresar una referencia");
		}
		
		if (bicicleta.getReferencia().length() < 5) {
			error("Debe ingresar una referencia mas larga");
		}
		
		if (bicicleta.getNombre() == null) {
			error("Debe ingresar un nombre");
		}
		
		if (bicicleta.getNombre().length() < 5) {
			error("DEbe ingresar un nombre mas largo");
		}
		
		if (bicicleta.getDescripcion() == null) {
			error("Debe ingresar una descripcion");
		}
		
		if (bicicleta.getDescripcion().length() < 10) {
			error("Debe ingresar una descripcion mas larga");
		}
		
		if (bicicleta.getPrecio() < 0) {
			error("Debe ingresar un precio válido");
		}
	}
	
	/**
	 * Método para lanzar excepcion con un mensaje
	 * @param msg Mensaje a lanzar
	 * @throws Exception
	 */
	private void error(String msg) throws Exception {
		throw new Exception(msg);
	}
}
