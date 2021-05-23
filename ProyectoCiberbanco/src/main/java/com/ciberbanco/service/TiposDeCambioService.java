package com.ciberbanco.service;
import java.util.List;
import com.ciberbanco.entity.TiposDeCambio;

public interface TiposDeCambioService {
public List<TiposDeCambio> findAll();
public TiposDeCambio save(TiposDeCambio tc);

}
