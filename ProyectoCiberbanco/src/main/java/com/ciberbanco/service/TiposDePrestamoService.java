package com.ciberbanco.service;
import java.util.List;
import com.ciberbanco.entity.TiposDePrestamo;

public interface TiposDePrestamoService {
	public List<TiposDePrestamo> listar();
	public List<TiposDePrestamo> listarPorMoneda(String moneda);
	public TiposDePrestamo save(TiposDePrestamo tp);
	public TiposDePrestamo findById(int id);
	public void deleteById(int id);
	
}
