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

import com.RocketbackEndJwt.api.entities.Cliente;
import com.RocketbackEndJwt.api.response.Response;
import com.RocketbackEndJwt.api.service.ClienteDAO;

@RestController
@RequestMapping("api/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {
	
	@Autowired
	private ClienteDAO dao;
	
	private Response<Cliente> respuesta;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Cliente>> create(@RequestBody Cliente cliente, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			// TODO: Validate data
			dao.save(cliente);
			respuesta = new Response<>(cliente, "Ok", 200);
			return new ResponseEntity<Response<Cliente>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>("Error creando clientes", 400);
			return new ResponseEntity<Response<Cliente>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Cliente>> list(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Cliente> clientes = (List<Cliente>) dao.findAll();
			respuesta = new Response<>(clientes, "Ok", 200);
			return new ResponseEntity<Response<Cliente>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>("Error Leyendo clientes", 400);
			return new ResponseEntity<Response<Cliente>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Cliente>> get(Long id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Cliente cliente = dao.findById(id).get();
			respuesta = new Response<>(cliente, "Ok", 200);
			return new ResponseEntity<Response<Cliente>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>("Error Leyendo cliente", 400);
			return new ResponseEntity<Response<Cliente>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Cliente>> update(Long id, @RequestBody Cliente newCliente, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Cliente cliente = dao.findById(id).get();
			cliente.setNombre(newCliente.getNombre());
			cliente.setApellidos(newCliente.getApellidos());
			cliente.setEmail(newCliente.getEmail());
			cliente.setPassword(newCliente.getPassword());
			cliente.setDireccion(newCliente.getDireccion());
			cliente.setTelefono(newCliente.getTelefono());
			cliente.setFecha_borrado(newCliente.getFecha_borrado());
			
			respuesta = new Response<>(cliente, "Ok", 200);
			return new ResponseEntity<Response<Cliente>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>("Error actualizando cliente", 400);
			return new ResponseEntity<Response<Cliente>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Cliente>> delete(Long id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Cliente cliente = dao.findById(id).get();
			dao.delete(cliente);
			respuesta = new Response<>("Ok", 200);
			return new ResponseEntity<Response<Cliente>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>("Error borrando cliente", 400);
			return new ResponseEntity<Response<Cliente>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}

}
