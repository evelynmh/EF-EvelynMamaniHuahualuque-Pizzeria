package com.idat.microservicioidat.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.idat.microservicioidat.dto.Pizza;

@FeignClient(name="idat-pizza", url="localhost:8080")
public interface OpenFeignClient {

	@GetMapping("/api/pizza/v1/listar")
	public List<Pizza> listarPizzasSeleccionados();
}
