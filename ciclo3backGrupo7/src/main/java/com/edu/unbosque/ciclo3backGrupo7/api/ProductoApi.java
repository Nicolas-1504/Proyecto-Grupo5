package com.edu.unbosque.ciclo3backGrupo7.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.unbosque.ciclo3backGrupo7.entities.Producto;
import com.edu.unbosque.ciclo3backGrupo7.entities.Usuario;
import com.edu.unbosque.ciclo3backGrupo7.repository.ProductoRepository;

@RestController
@RequestMapping("productos")
public class ProductoApi {

	@Autowired
	private ProductoRepository productoRepository;

	@PostMapping("/guardar")
	public void guardar(@RequestBody Producto producto) {
		productoRepository.save(producto);
	}
	
	@GetMapping("/listar")
	public List<Producto> listar(){
		return productoRepository.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Long id) {
		productoRepository.deleteById(id);
	}

	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Producto producto) {
		productoRepository.save(producto);
	}
}
