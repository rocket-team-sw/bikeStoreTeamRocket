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

import com.RocketbackEndJwt.api.entities.Marca;
import com.RocketbackEndJwt.api.response.Response;
import com.RocketbackEndJwt.api.service.MarcaDAO;

@RestController
@RequestMapping("api/marcas")
@CrossOrigin(origins = "*")
public class MarcaController {

	@Autowired
	private MarcaDAO dao;
	
	private Response<Marca> respuesta;
	private Marca emptyObject = new Marca();
	private ArrayList<Marca> emptyList = new ArrayList<>();
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Marca>> create(@RequestBody Marca marca, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			// TODO: Validate data
			dao.save(marca);
			respuesta = new Response<>(marca, emptyList, "Ok", 200);
			return new ResponseEntity<Response<Marca>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error creando marcas", 400);
			return new ResponseEntity<Response<Marca>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Marca>> list(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Marca> marcas = (List<Marca>) dao.findAll();
			respuesta = new Response<>(emptyObject, marcas, "Ok", 200);
			return new ResponseEntity<Response<Marca>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error Leyendo marcas", 400);
			return new ResponseEntity<Response<Marca>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Marca>> get(@PathVariable Long id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Marca marca = dao.findById(id).get();
			respuesta = new Response<>(marca, emptyList, "Ok", 200);
			return new ResponseEntity<Response<Marca>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error Leyendo marca", 400);
			return new ResponseEntity<Response<Marca>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Marca>> update(@PathVariable Long id, @RequestBody Marca newMarca, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Marca marca = dao.findById(id).get();
			marca.setNombre(newMarca.getNombre());
			marca.setDescripcion(newMarca.getDescripcion());
			marca.setFecha_borrado(newMarca.getFecha_borrado());
			
			respuesta = new Response<>(emptyObject, emptyList, "Ok", 200);
			return new ResponseEntity<Response<Marca>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error actualizando marca", 400);
			return new ResponseEntity<Response<Marca>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Marca>> delete(@PathVariable Long id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Marca marca = dao.findById(id).get();
			dao.delete(marca);
			respuesta = new Response<>(emptyObject, emptyList, "Ok", 200);
			return new ResponseEntity<Response<Marca>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error borrando marca", 400);
			return new ResponseEntity<Response<Marca>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
}
