package com.ciberbanco.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ciberbanco.dao.TiposDePrestamoDAO;
import com.ciberbanco.entity.TiposDePrestamo;

@Service
public class TiposDePrestamoServiceImpl implements TiposDePrestamoService{

	@Autowired
	private TiposDePrestamoDAO tiposDePrestamoDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<TiposDePrestamo> listar() {
		return(List<TiposDePrestamo>) tiposDePrestamoDAO.findAll();
	}

	@Override
	@Transactional
	public TiposDePrestamo save(TiposDePrestamo tp) {
		return tiposDePrestamoDAO.save(tp);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TiposDePrestamo> listarPorMoneda(String moneda) {
		return tiposDePrestamoDAO.listar(moneda);
	}

	@Override
	@Transactional(readOnly = true)
	public TiposDePrestamo findById(int id) {
		return tiposDePrestamoDAO.findById(id).orElse(null);
	}

	@Override
	public void deleteById(int id) {
		tiposDePrestamoDAO.deleteById(id);
	}

}
