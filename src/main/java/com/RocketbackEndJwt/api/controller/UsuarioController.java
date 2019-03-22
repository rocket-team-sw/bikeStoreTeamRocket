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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.RocketbackEndJwt.api.entities.Usuario;
import com.RocketbackEndJwt.api.security.jwt.JwtUser;
import com.RocketbackEndJwt.api.service.UserDao;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/* REGISTRAR USUARIO */
	/* SE RECIBE UN USUARIO PARA EL REGISTRO DEL MISMO */
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createUser(@RequestBody Usuario nuevoUsuario, HttpServletRequest request,
			HttpServletResponse response) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		try {
			
			if(usuarioDao.findByEmail(nuevoUsuario.getEmail())==null) 
			{
				nuevoUsuario.setPassword(passwordEncoder.encode(nuevoUsuario.getPassword()));
				usuarioDao.save(nuevoUsuario);	
				
			}
			else {
				
				logger.error("Error en el registro del usuario email repetido");
			}
			
		} catch (Exception e) {

			logger.error("Error en la creacion del usuario" + e.getMessage());

			return new ResponseEntity<String>("Error en la creacion del usuario", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Exito en la creacion del usuario", HttpStatus.OK);
	}
	
	
	/* DELETE USER */
	/* SE RECIBE UN correo de un USUARIO PARA EL BORRADO DEL MISMO */
	@RequestMapping(value = "/delete", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAnyRole('SUPER','ADMIN')")
	public @ResponseBody ResponseEntity<String> deleteUser(String correo, HttpServletRequest request,
			HttpServletResponse response) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		JwtUser customJWTUser = (JwtUser) authentication.getPrincipal();
		Usuario userAux = usuarioDao.findByEmail(correo);

		try {

			usuarioDao.delete(userAux);
			return new ResponseEntity<String>("{\"result\":\"exito\"}", HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error en el borrado del usuario" + e.getMessage());
			return new ResponseEntity<String>(
					"{\"result\":\"error\",\"info\":\"imposible resolver la peticion no se encuentra"
							+ " el usuario solicitado\"}",
					HttpStatus.BAD_REQUEST);
		}
	}

	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserDao usuarioDao;

}
