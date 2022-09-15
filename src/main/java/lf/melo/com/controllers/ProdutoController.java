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

import lf.melo.com.entities.Produto;
import lf.melo.com.services.ProdutoService;

@RestController
@RequestMapping("/products")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Produto> create(@RequestBody Produto Produto) {
		return ResponseEntity.ok().body(service.create(Produto));
	}
	
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity update(@RequestBody Produto Produto , @PathVariable Long id) {
		Produto produtoAtualizado = service.update(Produto, id);
		return ResponseEntity.ok().body(produtoAtualizado);
	}
	
}
