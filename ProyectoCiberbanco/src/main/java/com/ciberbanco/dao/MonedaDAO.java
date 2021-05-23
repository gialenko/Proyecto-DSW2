package com.ciberbanco.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ciberbanco.entity.Moneda;

@Repository("monedasRepository")
public interface MonedaDAO extends CrudRepository<Moneda, Integer>{

	@Query(value = "{call SP_LISTAR_MONEDAS}",nativeQuery = true)
	public List<Moneda> listar();
	
}
