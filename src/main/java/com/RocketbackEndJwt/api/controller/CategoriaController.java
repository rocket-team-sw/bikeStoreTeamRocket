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
import com.RocketbackEndJwt.api.response.Response;
import com.RocketbackEndJwt.api.service.CategoriaDAO;

@RestController
@RequestMapping("api/categorias")
@CrossOrigin(origins = "*")
public class CategoriaController {

	@Autowired
	private CategoriaDAO dao;
	
	private Response<Categoria> respuesta;
	private Categoria emptyObject = new Categoria();
	private ArrayList<Categoria> emptyList = new ArrayList<>();
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Categoria>> create(@RequestBody Categoria categoria, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			// TODO: Validate data
			dao.save(categoria);
			respuesta = new Response<>(categoria,emptyList, "Ok", 200);
			return new ResponseEntity<Response<Categoria>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error creando categorias", 400);
			return new ResponseEntity<Response<Categoria>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Categoria>> list(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Categoria> categorias = (List<Categoria>) dao.findAll();
			respuesta = new Response<>(emptyObject, categorias, "Ok", 200);
			return new ResponseEntity<Response<Categoria>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error Leyendo categorias", 400);
			return new ResponseEntity<Response<Categoria>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Categoria>> get(@PathVariable Long id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Categoria categoria = dao.findById(id).get();
			respuesta = new Response<>(categoria, emptyList, "Ok", 200);
			return new ResponseEntity<Response<Categoria>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error Leyendo categoria", 400);
			return new ResponseEntity<Response<Categoria>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Categoria>> update(@PathVariable Long id, @RequestBody Categoria newCategoria, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Categoria categoria = dao.findById(id).get();
			categoria.setDescripcion(newCategoria.getDescripcion());
			categoria.setFecha_borrado(newCategoria.getFecha_borrado());
			categoria.setNombre(newCategoria.getNombre());
			
			respuesta = new Response<>(emptyObject, emptyList, "Ok", 200);
			return new ResponseEntity<Response<Categoria>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error actualizando categoria", 400);
			return new ResponseEntity<Response<Categoria>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Categoria>> delete(@PathVariable Long id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Categoria categoria = dao.findById(id).get();
			dao.delete(categoria);
			respuesta = new Response<>(emptyObject, emptyList, "Ok", 200);
			return new ResponseEntity<Response<Categoria>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error borrando categoria", 400);
			return new ResponseEntity<Response<Categoria>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
}
