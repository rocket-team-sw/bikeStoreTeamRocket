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

import com.RocketbackEndJwt.api.entities.Venta;
import com.RocketbackEndJwt.api.response.Response;
import com.RocketbackEndJwt.api.service.VentaDAO;

@RestController
@RequestMapping("api/ventas")
@CrossOrigin(origins="*")
public class VentaController {
	
	@Autowired
	private VentaDAO dao;
	
	private Response<Venta> respuesta;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Venta>> create(@RequestBody Venta venta, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			// TODO: Validate data
			dao.save(venta);
			respuesta = new Response<>(venta, "Ok", 200);
			return new ResponseEntity<Response<Venta>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>("Error creando ventas", 400);
			return new ResponseEntity<Response<Venta>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Venta>> list(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Venta> ventas = (List<Venta>) dao.findAll();
			respuesta = new Response<>(ventas, "Ok", 200);
			return new ResponseEntity<Response<Venta>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>("Error Leyendo ventas", 400);
			return new ResponseEntity<Response<Venta>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Venta>> get(Long id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Venta venta = dao.findById(id).get();
			respuesta = new Response<>(venta, "Ok", 200);
			return new ResponseEntity<Response<Venta>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>("Error Leyendo venta", 400);
			return new ResponseEntity<Response<Venta>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Venta>> update(Long id, @RequestBody Venta newVenta, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Venta venta = dao.findById(id).get();
			venta.setFecha_borrado(newVenta.getFecha_borrado());
			
			respuesta = new Response<>(venta, "Ok", 200);
			return new ResponseEntity<Response<Venta>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>("Error actualizando venta", 400);
			return new ResponseEntity<Response<Venta>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Venta>> delete(Long id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Venta venta = dao.findById(id).get();
			dao.delete(venta);
			respuesta = new Response<>("Ok", 200);
			return new ResponseEntity<Response<Venta>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>("Error borrando venta", 400);
			return new ResponseEntity<Response<Venta>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}

}
