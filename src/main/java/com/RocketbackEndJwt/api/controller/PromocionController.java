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

import com.RocketbackEndJwt.api.entities.Promocion;
import com.RocketbackEndJwt.api.response.Response;
import com.RocketbackEndJwt.api.service.PromocionDAO;

@RestController
@RequestMapping("api/promociones")
@CrossOrigin(origins="*")
public class PromocionController {

	@Autowired
	private PromocionDAO dao;
	
	private Response<Promocion> respuesta;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Promocion>> create(@RequestBody Promocion promocion, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			// TODO: Validate data
			dao.save(promocion);
			respuesta = new Response<>(promocion, "Ok", 200);
			return new ResponseEntity<Response<Promocion>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>("Error creando promocions", 400);
			return new ResponseEntity<Response<Promocion>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Promocion>> list(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Promocion> promocions = (List<Promocion>) dao.findAll();
			respuesta = new Response<>(promocions, "Ok", 200);
			return new ResponseEntity<Response<Promocion>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>("Error Leyendo promocions", 400);
			return new ResponseEntity<Response<Promocion>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Promocion>> get(Long id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Promocion promocion = dao.findById(id).get();
			respuesta = new Response<>(promocion, "Ok", 200);
			return new ResponseEntity<Response<Promocion>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>("Error Leyendo promocion", 400);
			return new ResponseEntity<Response<Promocion>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Promocion>> update(Long id, @RequestBody Promocion newPromocion, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Promocion promocion = dao.findById(id).get();
			promocion.setNombre(newPromocion.getNombre());
			promocion.setDescripcion(newPromocion.getDescripcion());
			promocion.setPrecio(newPromocion.getPrecio());
			promocion.setDesde(newPromocion.getDesde());
			promocion.setHasta(newPromocion.getHasta());
			promocion.setFecha_borrado(newPromocion.getFecha_borrado());
			
			respuesta = new Response<>(promocion, "Ok", 200);
			return new ResponseEntity<Response<Promocion>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>("Error actualizando promocion", 400);
			return new ResponseEntity<Response<Promocion>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Promocion>> delete(Long id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Promocion promocion = dao.findById(id).get();
			dao.delete(promocion);
			respuesta = new Response<>("Ok", 200);
			return new ResponseEntity<Response<Promocion>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>("Error borrando promocion", 400);
			return new ResponseEntity<Response<Promocion>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
}
