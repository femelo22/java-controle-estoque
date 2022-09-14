package lf.melo.com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lf.melo.com.entities.Fornecedor;
import lf.melo.com.services.FornecedorService;

@RestController
@RequestMapping("/suppliers")
public class FornecedorController {
	
	@Autowired
	private FornecedorService service;

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Fornecedor> create(@RequestBody Fornecedor fornecedor) {
		return ResponseEntity.ok().body(service.create(fornecedor));
	}
	
	
	@GetMapping
	public ResponseEntity<List<Fornecedor>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Fornecedor> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity update(@RequestBody Fornecedor fornecedor , @PathVariable Long id) {
		Fornecedor fornAtualizado = service.update(fornecedor, id);
		return ResponseEntity.ok().body(fornAtualizado);
	}
	
}
