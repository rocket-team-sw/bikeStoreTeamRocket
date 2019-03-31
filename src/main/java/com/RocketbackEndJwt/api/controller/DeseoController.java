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

import com.RocketbackEndJwt.api.entities.Deseo;
import com.RocketbackEndJwt.api.response.Response;
import com.RocketbackEndJwt.api.service.DeseoDAO;

@RestController
@RequestMapping("api/deseos")
@CrossOrigin(origins = "*")
public class DeseoController {

	@Autowired
	private DeseoDAO dao;
	
	private Response<Deseo> respuesta;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Deseo>> create(@RequestBody Deseo deseo, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			// TODO: Validate data
			dao.save(deseo);
			respuesta = new Response<>(deseo, "Ok", 200);
			return new ResponseEntity<Response<Deseo>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>("Error creando deseos", 400);
			return new ResponseEntity<Response<Deseo>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Deseo>> list(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Deseo> deseos = (List<Deseo>) dao.findAll();
			respuesta = new Response<>(deseos, "Ok", 200);
			return new ResponseEntity<Response<Deseo>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>("Error Leyendo deseos", 400);
			return new ResponseEntity<Response<Deseo>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Deseo>> get(Long id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Deseo deseo = dao.findById(id).get();
			respuesta = new Response<>(deseo, "Ok", 200);
			return new ResponseEntity<Response<Deseo>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>("Error Leyendo deseo", 400);
			return new ResponseEntity<Response<Deseo>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Deseo>> update(Long id, @RequestBody Deseo newDeseo, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Deseo deseo = dao.findById(id).get();
			deseo.setBicicletaId(newDeseo.getBicicletaId());
			deseo.setClienteId(newDeseo.getClienteId());
			deseo.setFecha_borrado(newDeseo.getFecha_borrado());
			
			respuesta = new Response<>(deseo, "Ok", 200);
			return new ResponseEntity<Response<Deseo>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>("Error actualizando deseo", 400);
			return new ResponseEntity<Response<Deseo>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Deseo>> delete(Long id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Deseo deseo = dao.findById(id).get();
			dao.delete(deseo);
			respuesta = new Response<>("Ok", 200);
			return new ResponseEntity<Response<Deseo>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>("Error borrando deseo", 400);
			return new ResponseEntity<Response<Deseo>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
}
