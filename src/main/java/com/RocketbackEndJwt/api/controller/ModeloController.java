package com.RocketbackEndJwt.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.RocketbackEndJwt.api.entities.Modelo;
import com.RocketbackEndJwt.api.service.ModeloDAO;

@RestController
@RequestMapping("modelos")
@CrossOrigin(origins = "*")
public class ModelosController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ModeloDAO modeloDao;

	/* REGISTRAR MODELO */
	/* SE RECIBE UN MODELO PARA EL REGISTRO DEL MISMO */
	@RequestMapping(value = "register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAnyRole('SUPER','ADMIN', 'USER')")
	public ResponseEntity<String> crearModelo(@RequestBody Modelo nuevoModelo, HttpServletRequest request,
			HttpServletResponse response) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		try {
			modeloDao.save(nuevoModelo);
		} catch (Exception e) {
			logger.error("Error en la creacion del usuario" + e.getMessage());
			return new ResponseEntity<String>("Error en la creacion del modelo", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Exito en la creacion del modelo", HttpStatus.OK);
	}
}
