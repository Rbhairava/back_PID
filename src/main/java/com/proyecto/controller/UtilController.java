package com.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entity.Visitante;
import com.proyecto.service.VisitanteService;
import com.proyecto.util.AppSettings;

@RestController
@RequestMapping("/url/util")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)

public class UtilController {

	@Autowired
	private VisitanteService visitanteService;
	
	
	@GetMapping("/listaVisitante")
	@ResponseBody
	public ResponseEntity<List<Visitante>> listaVisitante() {
		List<Visitante> lista= visitanteService.listaVisitante();
		return ResponseEntity.ok(lista);
	}
	
}
