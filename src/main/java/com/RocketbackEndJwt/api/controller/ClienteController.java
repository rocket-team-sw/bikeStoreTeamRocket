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

import com.RocketbackEndJwt.api.entities.Cliente;
import com.RocketbackEndJwt.api.entities.Modelo;
import com.RocketbackEndJwt.api.response.Response;
import com.RocketbackEndJwt.api.response.ResponseCode;
import com.RocketbackEndJwt.api.service.ClienteDAO;

/**
 * Clase controladora para las peticiones relacionadas con clientes
 * @author juanfvasquez
 */
@RestController
@RequestMapping("api/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {
	
	@Autowired
	private ClienteDAO dao;
	
	private Response<Cliente> respuesta;
	
	private Cliente emptyObject = new Cliente();
	private ArrayList<Cliente> emptyList = new ArrayList<>();
	
	/**
	 * Método para crear un cliente
	 * @param cliente objeto Cliente con la información a registrar
	 * @return objeto Cliente creado
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Cliente>> create(@RequestBody Cliente cliente, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			validate(cliente);
			dao.save(cliente);
			respuesta = new Response<>(cliente, emptyList, "Ok", ResponseCode.OK_CODE);
			return new ResponseEntity<Response<Cliente>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error creando clientes. " + e.getMessage(), ResponseCode.ERROR_CODE);
			return new ResponseEntity<Response<Cliente>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Método para obtener todos los clientes
	 * @return lista de objetos Cliente
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Cliente>> list(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Cliente> clientes = (List<Cliente>) dao.findAll();
			respuesta = new Response<>(emptyObject, clientes, "Ok", ResponseCode.OK_CODE);
			return new ResponseEntity<Response<Cliente>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error Leyendo clientes", ResponseCode.ERROR_CODE);
			return new ResponseEntity<Response<Cliente>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Método para obtener un cliente dado un id
	 * @param id identificador de un cliente
	 * @return objeto Cliente 
	 */
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Cliente>> get(@PathVariable Long id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (id == null) {
				error("Debe ingresar un id");
			}
			Cliente cliente = dao.findById(id).get();
			if (cliente == null) {
				error("El id no esta registrado");
			}
			respuesta = new Response<>(cliente, emptyList, "Ok", ResponseCode.OK_CODE);
			return new ResponseEntity<Response<Cliente>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error Leyendo cliente. " + e.getMessage(), ResponseCode.ERROR_CODE);
			return new ResponseEntity<Response<Cliente>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Método para actualizar un cliente
	 * @param id identificador del cliente a actualizar
	 * @param newCliente objeto Cliente con los nuevos datos
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Cliente>> update(@PathVariable Long id, @RequestBody Cliente newCliente, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (id == null) {
				error("Debe ingresar un id");
			}
			Cliente cliente = dao.findById(id).get();
			if (cliente == null) {
				error("El id no esta registrado");
			}
			validate(newCliente);
			cliente.setNombre(newCliente.getNombre());
			cliente.setApellidos(newCliente.getApellidos());
			cliente.setEmail(newCliente.getEmail());
			cliente.setPassword(newCliente.getPassword());
			cliente.setDireccion(newCliente.getDireccion());
			cliente.setTelefono(newCliente.getTelefono());
			cliente.setFecha_borrado(newCliente.getFecha_borrado());
			
			respuesta = new Response<>(emptyObject, emptyList, "Ok", ResponseCode.OK_CODE);
			return new ResponseEntity<Response<Cliente>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error actualizando cliente. " + e.getMessage(), ResponseCode.ERROR_CODE);
			return new ResponseEntity<Response<Cliente>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Método para eliminar un cliente
	 * @param id identificador del cliente
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Cliente>> delete(@PathVariable Long id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (id == null) {
				error("Debe ingresar un id");
			}
			Cliente cliente = dao.findById(id).get();
			if (cliente == null) {
				error("El id no esta registrado");
			}
			dao.delete(cliente);
			respuesta = new Response<>(emptyObject, emptyList, "Ok", ResponseCode.OK_CODE);
			return new ResponseEntity<Response<Cliente>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error borrando cliente. " + e.getMessage(), ResponseCode.ERROR_CODE);
			return new ResponseEntity<Response<Cliente>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Método para validar la información de un cliente antes de crear o actualizar
	 * @param cliente objeto Cliente con los datos a validar
	 * @throws Exception lanzada si se encuentra un dato que no es válido
	 */
	private void validate(Cliente cliente) throws Exception {
		
		if (cliente.getNombre() == null) {
			error("Debe ingresar un nombre");
		}
		
		if (cliente.getNombre().length() < 3) {
			error("DEbe ingresar un nombre mas largo");
		}
		
		if (cliente.getApellidos() == null) {
			error("Debe ingresar apellidos");
		}
		
		if (cliente.getApellidos().length() < 3) {
			error("DEbe ingresar apellido mas largo");
		}
		
		if (cliente.getEmail() == null) {
			error("Debe ingresar un email");
		}
		
		if (cliente.getEmail().length() < 7) {
			error("DEbe ingresar un email mas largo");
		}
	}
	
	/**
	 * Mètodo para lanzar una excepción con un mensaje
	 * @param msg Mensaje a mostrar
	 * @throws Exception
	 */
	private void error(String msg) throws Exception {
		throw new Exception(msg);
	}
}
