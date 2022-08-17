package com.idat.microservicioidat.conntroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.idat.microservicioidat.entity.Pizzeria;
import com.idat.microservicioidat.service.PizzeriaService;

@RestController
@RequestMapping("/api/pizzeria/v1")
public class PizzeriaController {

	@Autowired
	private PizzeriaService service;

	@PostMapping("/guardar")
	public @ResponseBody void guardar(@RequestBody Pizzeria pizzeria) {
		service.guardar(pizzeria);
	}
	
	@GetMapping("/asignar")
	public @ResponseBody void asignarPizzaCliente() {
		service.asignarPizzaPizzeria();
	}
}
