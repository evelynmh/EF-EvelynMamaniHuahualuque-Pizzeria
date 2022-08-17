package com.idat.microservicioidat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.microservicioidat.client.OpenFeignClient;
import com.idat.microservicioidat.dto.Pizza;
import com.idat.microservicioidat.entity.PizzaPizzeriaFK;
import com.idat.microservicioidat.entity.PizzeriaDetalle;
import com.idat.microservicioidat.entity.Pizzeria;
import com.idat.microservicioidat.repository.PizzeriaRepository;
import com.idat.microservicioidat.repository.DetallePizzeriaRepository;
import com.idat.microservicioidat.service.PizzeriaService;

@Service
public class PizzeriaServiceImpl implements PizzeriaService{

	@Autowired
	private PizzeriaRepository repositoryPizzeria;
	
	@Autowired
	private DetallePizzeriaRepository repositoryDetalle;
	
	@Autowired
	private OpenFeignClient feign;
	
	@Override
	public void guardar(Pizzeria pizzeria) {
		repositoryPizzeria.save(pizzeria);
	}
	
	@Override
	public List<Pizzeria> listar() {
		return repositoryPizzeria.findAll();
	}

	@Override
	public Pizzeria ObtenerId(Integer id) {
		return repositoryPizzeria.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id) {
		repositoryPizzeria.deleteById(id);
		
	}

	@Override
	public void actualizar(Pizzeria pizzeria) {
		repositoryPizzeria.saveAndFlush(pizzeria);
		
	}
	
	@Override
	public void asignarPizzaPizzeria() {
		
		List<Pizza> listado = feign.listarPizzasSeleccionados();
		PizzaPizzeriaFK fk = null;
		PizzeriaDetalle detalle = null;

		
		for (Pizza pizza : listado) {
			
			fk = new PizzaPizzeriaFK();
			fk.setIdPizza(pizza.getIdPizza());
			fk.setIdPizzeria(1);
			
			detalle = new PizzeriaDetalle();
			detalle.setFk(fk);	
			
			repositoryDetalle.save(detalle);
		}

	}
}
