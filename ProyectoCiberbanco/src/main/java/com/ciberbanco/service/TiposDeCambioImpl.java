package com.ciberbanco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ciberbanco.dao.TiposDeCambioDAO;
import com.ciberbanco.entity.TiposDeCambio;

@Service
public class TiposDeCambioImpl implements TiposDeCambioService{

	@Autowired
	private TiposDeCambioDAO tiposDeCambio;
	
	@Transactional(readOnly = true)
	@Override
	public List<TiposDeCambio> findAll() {
		return (List<TiposDeCambio>)tiposDeCambio.findAll();
	}

	@Transactional
	@Override
	public TiposDeCambio save(TiposDeCambio tc) {
		return tiposDeCambio.save(tc);
	}

}
