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

import com.edu.unbosque.ciclo3backGrupo7.entities.Cliente;
import com.edu.unbosque.ciclo3backGrupo7.repository.ClienteRepository;

@RestController
@RequestMapping("clientes")
public class ClienteApi {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	@GetMapping("/listar")
	public List<Cliente> listar(){
		return clienteRepository.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Long id) {
		clienteRepository.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Cliente cliente) {
		clienteRepository.save(cliente);
	}
}
