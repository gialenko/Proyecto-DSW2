package com.ciberbanco.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.ciberbanco.entity.TiposDeCambio;
import com.ciberbanco.service.MonedaService;
import com.ciberbanco.service.TiposDeCambioService;

@RestController
@RequestMapping("/api")
public class TiposDeCambioController {
	
	@Autowired
	private TiposDeCambioService tiposDeCambioService;
	
	@GetMapping("/tc")
	public List<TiposDeCambio> listar(){
		return tiposDeCambioService.findAll();
	}
	
	@PostMapping("/tc")
	@ResponseStatus(HttpStatus.CREATED)
	public TiposDeCambio save(@RequestBody TiposDeCambio tc) {
		return tiposDeCambioService.save(tc);
	}

}
