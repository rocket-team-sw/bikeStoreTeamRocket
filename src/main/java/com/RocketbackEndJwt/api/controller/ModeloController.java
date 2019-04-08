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

import com.RocketbackEndJwt.api.entities.Modelo;
import com.RocketbackEndJwt.api.response.Response;
import com.RocketbackEndJwt.api.service.ModeloDAO;

@RestController
@RequestMapping("api/modelos")
@CrossOrigin(origins = "*")
public class ModeloController {

	@Autowired
	private ModeloDAO dao;
	
	private Response<Modelo> respuesta;
	private Modelo emptyObject = new Modelo();
	private ArrayList<Modelo> emptyList = new ArrayList<>();
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Modelo>> create(@RequestBody Modelo modelo, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			// TODO: Validate data
			dao.save(modelo);
			respuesta = new Response<>(modelo, emptyList, "Ok", 200);
			return new ResponseEntity<Response<Modelo>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error creando modelos", 400);
			return new ResponseEntity<Response<Modelo>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Modelo>> list(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Modelo> modelos = (List<Modelo>) dao.findAll();
			respuesta = new Response<>(emptyObject, modelos, "Ok", 200);
			return new ResponseEntity<Response<Modelo>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error Leyendo modelos", 400);
			return new ResponseEntity<Response<Modelo>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Modelo>> get(@PathVariable Long id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Modelo modelo = dao.findById(id).get();
			respuesta = new Response<>(modelo, emptyList, "Ok", 200);
			return new ResponseEntity<Response<Modelo>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error Leyendo modelo", 400);
			return new ResponseEntity<Response<Modelo>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Modelo>> update(@PathVariable Long id, @RequestBody Modelo newModelo, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Modelo modelo = dao.findById(id).get();
			modelo.setNombre(newModelo.getNombre());
			modelo.setDescripcion(newModelo.getDescripcion());
			modelo.setFecha_borrado(newModelo.getFecha_borrado());
			
			respuesta = new Response<>(emptyObject, emptyList, "Ok", 200);
			return new ResponseEntity<Response<Modelo>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error actualizando modelo", 400);
			return new ResponseEntity<Response<Modelo>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Modelo>> delete(@PathVariable Long id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Modelo modelo = dao.findById(id).get();
			dao.delete(modelo);
			respuesta = new Response<>(emptyObject, emptyList, "Ok", 200);
			return new ResponseEntity<Response<Modelo>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error borrando modelo", 400);
			return new ResponseEntity<Response<Modelo>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
}
