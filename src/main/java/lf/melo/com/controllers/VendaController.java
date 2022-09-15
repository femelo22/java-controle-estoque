package lf.melo.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lf.melo.com.entities.Venda;
import lf.melo.com.entities.dtos.VendaDTO;
import lf.melo.com.services.VendaService;

@RestController
@RequestMapping("/sales")
public class VendaController {
	
	@Autowired
	private VendaService service;

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Venda> create(@RequestBody VendaDTO dto) {
		return ResponseEntity.ok().body(service.create(dto));
	}
	
//	
//	@GetMapping
//	public ResponseEntity<List<Venda>> findAll() {
//		return ResponseEntity.ok().body(service.findAll());
//	}
//	
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<Venda> findById(@PathVariable Long id) {
//		return ResponseEntity.ok().body(service.findById(id));
//	}
//	
//	
//	@DeleteMapping("/{id}")
//	public ResponseEntity delete(@PathVariable Long id) {
//		service.delete(id);
//		return ResponseEntity.noContent().build();
//	}
//	
//	@PutMapping("/{id}")
//	public ResponseEntity update(@RequestBody Venda Venda , @PathVariable Long id) {
//		Venda VendaAtualizado = service.update(Venda, id);
//		return ResponseEntity.ok().body(VendaAtualizado);
//	}
	
}
