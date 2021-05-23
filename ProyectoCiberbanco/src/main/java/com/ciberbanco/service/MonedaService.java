package com.ciberbanco.service;
import java.util.List;
import com.ciberbanco.entity.Moneda;

public interface MonedaService {
public List<Moneda> findAll();
public Moneda findById(int id);
public Moneda save(Moneda moneda);
public void delete(int id);
}
