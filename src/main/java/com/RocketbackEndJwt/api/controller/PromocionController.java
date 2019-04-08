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
	private Promocion emptyObject = new Promocion();
	private ArrayList<Promocion> emptyList = new ArrayList<>();
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Promocion>> create(@RequestBody Promocion promocion, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			// TODO: Validate data
			dao.save(promocion);
			respuesta = new Response<>(promocion, emptyList, "Ok", 200);
			return new ResponseEntity<Response<Promocion>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error creando promocions", 400);
			return new ResponseEntity<Response<Promocion>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Promocion>> list(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Promocion> promociones = (List<Promocion>) dao.findAll();
			respuesta = new Response<>(emptyObject, promociones, "Ok", 200);
			return new ResponseEntity<Response<Promocion>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error Leyendo promocions", 400);
			return new ResponseEntity<Response<Promocion>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Promocion>> get(@PathVariable Long id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Promocion promocion = dao.findById(id).get();
			respuesta = new Response<>(promocion, emptyList, "Ok", 200);
			return new ResponseEntity<Response<Promocion>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error Leyendo promocion", 400);
			return new ResponseEntity<Response<Promocion>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Promocion>> update(@PathVariable Long id, @RequestBody Promocion newPromocion, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Promocion promocion = dao.findById(id).get();
			promocion.setNombre(newPromocion.getNombre());
			promocion.setDescripcion(newPromocion.getDescripcion());
			promocion.setPrecio(newPromocion.getPrecio());
			promocion.setDesde(newPromocion.getDesde());
			promocion.setHasta(newPromocion.getHasta());
			promocion.setFecha_borrado(newPromocion.getFecha_borrado());
			
			respuesta = new Response<>(emptyObject, emptyList, "Ok", 200);
			return new ResponseEntity<Response<Promocion>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error actualizando promocion", 400);
			return new ResponseEntity<Response<Promocion>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Promocion>> delete(@PathVariable Long id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Promocion promocion = dao.findById(id).get();
			dao.delete(promocion);
			respuesta = new Response<>(emptyObject, emptyList, "Ok", 200);
			return new ResponseEntity<Response<Promocion>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error borrando promocion", 400);
			return new ResponseEntity<Response<Promocion>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
}
