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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.RocketbackEndJwt.api.entities.Bicicleta;
import com.RocketbackEndJwt.api.response.Response;
import com.RocketbackEndJwt.api.service.BIcicletaDAO;

@RestController
@RequestMapping("api/buscar")
@CrossOrigin(origins="*")
public class BusquedaController {
	
	@Autowired
	private BIcicletaDAO bicicletaDao;
	
	private Response<Bicicleta> respuesta;
	private Bicicleta emptyObject = new Bicicleta();
	private ArrayList<Bicicleta> emptyList = new ArrayList<>();

	@RequestMapping(value = "/{query}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response<Bicicleta>> list(@PathVariable String query, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Bicicleta> bicicletas = (List<Bicicleta>) bicicletaDao.findAll();
			List<Bicicleta> filtradas = new ArrayList<>();
			for (Bicicleta b : bicicletas) {
				if (b.getNombre().toLowerCase().indexOf(query.toLowerCase()) >= 0
					||
					b.getDescripcion().toLowerCase().indexOf(query.toLowerCase())  >= 0
					) {
					filtradas.add(b);
				}
			}
			respuesta = new Response<>(emptyObject, filtradas, "Ok", 200);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Response<>(emptyObject, emptyList, "Error buscando bicicletas", 400);
			return new ResponseEntity<Response<Bicicleta>>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}
}
