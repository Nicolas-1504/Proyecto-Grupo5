package com.edu.unbosque.ciclo3backGrupo7.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.unbosque.ciclo3backGrupo7.entities.DetalleVenta;
import com.edu.unbosque.ciclo3backGrupo7.repository.DetalleVentaRepository;

@RestController
@RequestMapping("detalleventas")
public class DetalleVentaApi {

	@Autowired
	private DetalleVentaRepository detalleVentaRepository;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody DetalleVenta detalleVenta) {
		detalleVentaRepository.save(detalleVenta);
	}
}
