package com.RocketbackEndJwt.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.RocketbackEndJwt.api.entities.Bicicleta;
import com.RocketbackEndJwt.api.response.Response;
import com.RocketbackEndJwt.api.service.BIcicletaDAO;

@RestController
@RequestMapping("api/bicicletas")
@CrossOrigin(origins = "*")
public class BicicletaController {

	@Autowired
	private BIcicletaDAO bicicletaDao;
	
	private Response<Bicicleta> respuesta;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Bicicleta>> create(@RequestBody Bicicleta bicicleta, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			// TODO: Validate data
			bicicletaDao.save(bicicleta);
			respuesta = new Response<>(bicicleta, "Ok", 200);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>("Error creando Bicicleta", 400);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Bicicleta>> list(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Bicicleta> bicicletas = (List<Bicicleta>)bicicletaDao.findAll();
			respuesta = new Response<>(bicicletas, "Ok", 200);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>("Error Leyendo bicicletas", 400);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Bicicleta>> get(Long id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Bicicleta bicicleta = bicicletaDao.findById(id).get();
			respuesta = new Response<>(bicicleta, "Ok", 200);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>("Error Leyendo bicicleta", 400);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Bicicleta>> update(Long id, @RequestBody Bicicleta newBicicleta, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Bicicleta bicicleta = bicicletaDao.findById(id).get();
			bicicleta.setReferencia(newBicicleta.getReferencia());
			bicicleta.setNombre(newBicicleta.getNombre());
			bicicleta.setDescripcion(newBicicleta.getDescripcion());
			bicicleta.setPrecio(newBicicleta.getPrecio());
			bicicleta.setUsada(newBicicleta.isUsada());
			bicicleta.setFecha_borrado(newBicicleta.getFecha_borrado());
			bicicleta.setCategoria(newBicicleta.getCategoria());
			bicicleta.setModelo(newBicicleta.getModelo());
			bicicleta.setMarca(newBicicleta.getMarca());
			
			respuesta = new Response<>(bicicleta, "Ok", 200);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>("Error actualizando bicicleta", 400);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Bicicleta>> delete(Long id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Bicicleta bicicleta = bicicletaDao.findById(id).get();
			bicicletaDao.delete(bicicleta);
			respuesta = new Response<>("Ok", 200);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>("Error borrando bicicleta", 400);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
}
