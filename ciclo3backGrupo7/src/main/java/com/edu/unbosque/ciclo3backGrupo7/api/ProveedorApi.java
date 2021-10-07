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

import com.edu.unbosque.ciclo3backGrupo7.entities.Proveedor;
import com.edu.unbosque.ciclo3backGrupo7.repository.ProveedorRepository;

@RestController
@RequestMapping("proveedores")
public class ProveedorApi {

	@Autowired
	ProveedorRepository proveedorRepository;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Proveedor proveedor) {
		proveedorRepository.save(proveedor);
	}
	
	@GetMapping("/listar")
	public List<Proveedor> listar(){
		return proveedorRepository.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Long id) {
		proveedorRepository.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Proveedor proveedor) {
		proveedorRepository.save(proveedor);
	}
}
