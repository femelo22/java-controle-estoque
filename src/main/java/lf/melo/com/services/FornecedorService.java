package lf.melo.com.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lf.melo.com.entities.Fornecedor;
import lf.melo.com.repositories.FornecedorRepository;

@Service
public class FornecedorService {
	
	@Autowired
	private FornecedorRepository repository;

	public Fornecedor create(Fornecedor fornecedor) {
		return repository.save(fornecedor);
	}
	
	public Fornecedor findById(Long id) {
		return repository.findById(id).get();
	}
	
	
	public List<Fornecedor> findAll() {
		return repository.findAll();
	}
	
	
	public void delete(Long id) {
		Fornecedor fornecedor = findById(id);
		repository.delete(fornecedor);
	}
	
	public Fornecedor update(Fornecedor fornecedor, Long id) {
		Fornecedor newFornecedor = findById(id);
		
		BeanUtils.copyProperties(fornecedor, newFornecedor);
		
		newFornecedor.setId(id);
		
		return repository.save(newFornecedor);
	}
	
}
