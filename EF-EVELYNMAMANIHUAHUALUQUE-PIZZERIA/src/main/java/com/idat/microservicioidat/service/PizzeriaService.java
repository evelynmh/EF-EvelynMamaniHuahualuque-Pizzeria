package com.idat.microservicioidat.service;

import java.util.List;

import com.idat.microservicioidat.entity.Pizzeria;

public interface PizzeriaService {

	List<Pizzeria> listar();
	Pizzeria ObtenerId(Integer id);	
	void guardar(Pizzeria pizzeria);
	void eliminar(Integer id);
	void actualizar(Pizzeria pizzeria);
	
	void asignarPizzaPizzeria();
}
