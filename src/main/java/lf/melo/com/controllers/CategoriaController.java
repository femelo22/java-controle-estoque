package lf.melo.com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lf.melo.com.entities.Categoria;
import lf.melo.com.services.CategoriaService;

@RestController
@RequestMapping("/categories")
public class CategoriaController {
	
	@Autowired
	private CategoriaService service;

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Categoria> create(@RequestBody Categoria categoria) {
		return ResponseEntity.ok().body(service.create(categoria));
	}
	
	
	@GetMapping
	public ResponseEntity<List<Categoria>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
