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

import com.RocketbackEndJwt.api.entities.Bicicleta;
import com.RocketbackEndJwt.api.response.Response;
import com.RocketbackEndJwt.api.service.BIcicletaDAO;

@RestController
@RequestMapping("api/bicicletas")
@CrossOrigin(origins = "*")
public class BicicletaController {

	@Autowired
	private BIcicletaDAO bicicletaDao;
	
	private Response<Bicicleta> respuesta;
	private Bicicleta emptyObject = new Bicicleta();
	private ArrayList<Bicicleta> emptyList = new ArrayList<>();
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Bicicleta>> create(@RequestBody Bicicleta bicicleta, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			validate(bicicleta);
			bicicletaDao.save(bicicleta);
			respuesta = new Response<>(bicicleta, emptyList, "Ok", 200);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error creando Bicicleta. " + e.getMessage(), 400);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Bicicleta>> list(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Bicicleta> bicicletas = (List<Bicicleta>) bicicletaDao.findAll();
			respuesta = new Response<>(emptyObject, bicicletas, "Ok", 200);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error Leyendo bicicletas", 400);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Bicicleta>> get(@PathVariable Long id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (id == null) {
				error("Debe ingresar un id válido");
			}
			Bicicleta bicicleta = bicicletaDao.findById(id).get();
			if (bicicleta == null) {
				error("El id no esta registrado");
			}
			respuesta = new Response<>(bicicleta, emptyList, "Ok", 200);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error Leyendo bicicleta. " + e.getMessage(), 400);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Bicicleta>> update(@PathVariable Long id, @RequestBody Bicicleta newBicicleta, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (id == null) {
				error("Debe ingresar un id válido");
			}
			Bicicleta bicicleta = bicicletaDao.findById(id).get();
			if (bicicleta == null) {
				error("El id no esta registrado");
			}
			bicicleta.setReferencia(newBicicleta.getReferencia());
			bicicleta.setNombre(newBicicleta.getNombre());
			bicicleta.setDescripcion(newBicicleta.getDescripcion());
			bicicleta.setPrecio(newBicicleta.getPrecio());
			bicicleta.setUsada(newBicicleta.isUsada());
			bicicleta.setFecha_borrado(newBicicleta.getFecha_borrado());
			bicicleta.setCategoria(newBicicleta.getCategoria());
			bicicleta.setModelo(newBicicleta.getModelo());
			bicicleta.setMarca(newBicicleta.getMarca());
			
			respuesta = new Response<>(bicicleta, emptyList, "Ok", 200);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error actualizando bicicleta. " + e.getMessage(), 400);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Bicicleta>> delete(@PathVariable Long id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (id == null) {
				error("Debe ingresar un id válido");
			}
			Bicicleta bicicleta = bicicletaDao.findById(id).get();
			if (bicicleta == null) {
				error("El id no esta registrado");
			}
			bicicletaDao.delete(bicicleta);
			respuesta = new Response<>(emptyObject, emptyList, "Ok", 200);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error borrando bicicleta. " + e.getMessage(), 400);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
	
	private void validate(Bicicleta bicicleta) throws Exception {
		if (bicicleta.getReferencia() == null) {
			error("Debe ingresar una referencia");
		}
		
		if (bicicleta.getReferencia().length() < 5) {
			error("Debe ingresar una referencia mas larga");
		}
		
		if (bicicleta.getNombre() == null) {
			error("Debe ingresar un nombre");
		}
		
		if (bicicleta.getNombre().length() < 5) {
			error("DEbe ingresar un nombre mas largo");
		}
		
		if (bicicleta.getDescripcion() == null) {
			error("Debe ingresar una descripcion");
		}
		
		if (bicicleta.getDescripcion().length() < 10) {
			error("Debe ingresar una descripcion mas larga");
		}
		
		if (bicicleta.getPrecio() < 0) {
			error("Debe ingresar un precio válido");
		}
	}
	
	private void error(String msg) throws Exception {
		throw new Exception(msg);
	}
}
