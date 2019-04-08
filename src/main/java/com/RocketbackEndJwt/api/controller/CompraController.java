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

import com.RocketbackEndJwt.api.entities.Compra;
import com.RocketbackEndJwt.api.response.Response;
import com.RocketbackEndJwt.api.service.CompraDAO;

@RestController
@RequestMapping("api/compras")
@CrossOrigin(origins = "*")
public class CompraController {

	@Autowired
	private CompraDAO dao;
	
	private Response<Compra> respuesta;
	private Compra emptyObject = new Compra();
	private ArrayList<Compra> emptyList = new ArrayList<>();
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Compra>> create(@RequestBody Compra compra, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			// TODO: Validate data
			dao.save(compra);
			respuesta = new Response<>(compra, emptyList, "Ok", 200);
			return new ResponseEntity<Response<Compra>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error creando compras", 400);
			return new ResponseEntity<Response<Compra>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Compra>> list(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Compra> compras = (List<Compra>) dao.findAll();
			respuesta = new Response<>(emptyObject, compras, "Ok", 200);
			return new ResponseEntity<Response<Compra>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error Leyendo compras", 400);
			return new ResponseEntity<Response<Compra>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Compra>> get(@PathVariable Long id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Compra compra = dao.findById(id).get();
			respuesta = new Response<>(compra, emptyList, "Ok", 200);
			return new ResponseEntity<Response<Compra>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error Leyendo compra", 400);
			return new ResponseEntity<Response<Compra>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Compra>> update(@PathVariable Long id, @RequestBody Compra newCompra, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Compra compra = dao.findById(id).get();
			compra.setFecha_borrado(newCompra.getFecha_borrado());
			
			respuesta = new Response<>(emptyObject, emptyList, "Ok", 200);
			return new ResponseEntity<Response<Compra>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error actualizando compra", 400);
			return new ResponseEntity<Response<Compra>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Compra>> delete(@PathVariable Long id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Compra compra = dao.findById(id).get();
			dao.delete(compra);
			respuesta = new Response<>(emptyObject, emptyList, "Ok", 200);
			return new ResponseEntity<Response<Compra>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error borrando compra", 400);
			return new ResponseEntity<Response<Compra>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
}
