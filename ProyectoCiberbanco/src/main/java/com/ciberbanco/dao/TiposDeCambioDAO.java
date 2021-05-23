package com.ciberbanco.dao;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ciberbanco.entity.TiposDeCambio;

@Repository("tipoDeCambioRepository")
public interface TiposDeCambioDAO extends CrudRepository<TiposDeCambio, Integer>{

	
	
}
