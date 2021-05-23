package com.ciberbanco.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ciberbanco.entity.Moneda;
import com.ciberbanco.entity.TiposDePrestamo;

@Repository("tiposDePrestamoRepository")
public interface TiposDePrestamoDAO extends CrudRepository<TiposDePrestamo, Integer>{
	
	@Query(value = "{call SP_LISTAR_TIPOS_PRESTAMO(:moneda)}",nativeQuery = true)
	public List<TiposDePrestamo> listar(@Param("moneda") String moneda);

}
