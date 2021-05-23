package com.ciberbanco.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ciberbanco.dao.MonedaDAO;
import com.ciberbanco.entity.Moneda;

@Service
public class MonedaServiceImpl implements MonedaService{

	@Autowired
	private MonedaDAO monedaDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Moneda> findAll() {
		return (List<Moneda>)monedaDAO.listar();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Moneda findById(int id) {
		return monedaDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Moneda save(Moneda moneda) {
		return monedaDAO.save(moneda);
	}

	@Override
	@Transactional
	public void delete(int id) {
		monedaDAO.deleteById(id);
	}

}
