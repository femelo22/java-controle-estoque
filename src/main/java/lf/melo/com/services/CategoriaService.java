package lf.melo.com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lf.melo.com.entities.Categoria;
import lf.melo.com.errors.NotFoundError;
import lf.melo.com.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria create(Categoria categoria) {
		return repository.save(categoria);
	}

	public Categoria findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundError("Categoria não encontrada!"));
	}

	public List<Categoria> findAll() {
		return repository.findAll();
	}

	public void delete(Long id) {
		Categoria Categoria = findById(id);
		repository.delete(Categoria);
	}

}