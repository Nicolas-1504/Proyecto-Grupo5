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

import com.edu.unbosque.ciclo3backGrupo7.entities.Usuario;
import com.edu.unbosque.ciclo3backGrupo7.repository.UsuarioRepository;

@RestController
@RequestMapping("usuarios")
public class UsuarioApi {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	@GetMapping("/listar")
	public List<Usuario> listar(){
		return usuarioRepository.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Long id) {
		usuarioRepository.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Usuario usuario) {
		usuarioRepository.save(usuario);
	}

}
