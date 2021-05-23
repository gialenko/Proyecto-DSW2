package com.ciberbanco.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.ciberbanco.entity.Moneda;
import com.ciberbanco.service.MonedaService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class MonedaController {
	
	@Autowired
	private MonedaService monedaService;
	
	@GetMapping("/monedas")
	public List<Moneda> listar(){
		return monedaService.findAll();
	}
	
	@GetMapping("/monedas/{id}")
	public Moneda listarPorId(@PathVariable Integer id){
		return monedaService.findById(id);
	}
	
	@PostMapping("/monedas")
	@ResponseStatus(HttpStatus.CREATED)
	public Moneda guardar(@RequestBody Moneda moneda) {
		System.out.println(""+moneda.getMoneda());
		return monedaService.save(moneda);
	}

	@PutMapping("/monedas/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Moneda actualizar(@RequestBody Moneda moneda, @PathVariable Integer id){
		Moneda m = monedaService.findById(id);
		m.setMoneda(moneda.getMoneda());
		return monedaService.save(m);
	}
	
	@DeleteMapping("monedas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Integer id) {
		monedaService.delete(id);
	}
	
}
