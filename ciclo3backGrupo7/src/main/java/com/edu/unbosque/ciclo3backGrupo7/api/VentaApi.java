package com.edu.unbosque.ciclo3backGrupo7.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.unbosque.ciclo3backGrupo7.entities.Venta;
import com.edu.unbosque.ciclo3backGrupo7.repository.VentaRepository;

@RestController
@RequestMapping("ventas")
public class VentaApi {

	@Autowired
	private VentaRepository ventaRepository;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Venta venta) {
		ventaRepository.save(venta);
	}
}
