package com.ciberbanco.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.ciberbanco.entity.TiposDePrestamo;
import com.ciberbanco.service.TiposDePrestamoService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.OptBoolean;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class TiposDePrestamoController {

	@Autowired
	private TiposDePrestamoService tiposDePrestamoService;
	
	@GetMapping("/tipoDePrestamo")
	public List<TiposDePrestamo> listar(@RequestParam(value="moneda",required = false) String moneda){
		/*JSONObject items = new JSONObject();
		JSONArray array = new JSONArray();
		JSONArray arrayMoneda = new JSONArray();
		for(TiposDePrestamo tp:tiposDePrestamoService.listarPorMoneda(moneda)){
			JSONObject object = new JSONObject();
			object.put("ID", tp.getId());
			object.put("Descripcion", tp.getDescripcion());
			object.put("Plazos", tp.getPlazos());
			object.put("Monto", tp.getMonto());
			object.put("MonedaID", tp.getMoneda_id());
			JSONObject objectMoneda = new JSONObject();
			if(tp.getMoneda().getId() != tp.getMoneda_id()) {
				continue;
			}
			objectMoneda.put("ID", tp.getMoneda().getId());
			objectMoneda.put("Moneda", tp.getMoneda().getMoneda());
			arrayMoneda.add(objectMoneda);			
			object.put("Moneda", arrayMoneda);
			array.add(object);	
		}
		items.put("items", array);
		return items; */
		return tiposDePrestamoService.listarPorMoneda(moneda);
	}
	
	@GetMapping("/tipoDePrestamo/{id}")
	public ResponseEntity<?> tiposDePrestamoPorId(@PathVariable Integer id) {
		TiposDePrestamo tp = null;
		Map<String,Object> response= new HashMap<>();
		try {
			tp = tiposDePrestamoService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje","Error al realizar la consulta");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(tp==null) {
			response.put("mensaje","El tipo de prestamo: ".concat(id.toString().concat(" no existe")));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<TiposDePrestamo>(tp,HttpStatus.OK);
	}
	
	
	@PostMapping("/tipoDePrestamo")
	public ResponseEntity<?> crear(@RequestBody TiposDePrestamo tp){
		TiposDePrestamo t = null;
		Map<String,Object> response= new HashMap<>();
		try {
			t = tiposDePrestamoService.save(tp);
		} catch (DataAccessException e) {
			response.put("mensaje","Error al realizar la creación");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El tipo de préstamo fue creado con éxito!");
		response.put("cliente", t);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	}
	
	@PutMapping("/tipoDePrestamo/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public TiposDePrestamo update(@RequestBody TiposDePrestamo t, @PathVariable Integer id) {
		TiposDePrestamo tp = tiposDePrestamoService.findById(id);
		tp.setPlazos(t.getPlazos());
		tp.setMonto(t.getMonto());
		tp.setDescripcion(t.getDescripcion());
		tp.setMoneda_id(t.getMoneda_id());
		return tiposDePrestamoService.save(tp);
	}
	
	@DeleteMapping("/tipoDePrestamo/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Integer id) {
		tiposDePrestamoService.deleteById(id);
	}
	
}
