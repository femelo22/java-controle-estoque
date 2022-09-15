package lf.melo.com.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lf.melo.com.entities.Categoria;
import lf.melo.com.entities.Fornecedor;
import lf.melo.com.entities.Produto;
import lf.melo.com.errors.NotFoundError;
import lf.melo.com.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;

	@Autowired
	private FornecedorService fornecedorService;
	
	@Autowired
	private CategoriaService catService;
	
	public Produto create(Produto produto) {
		
		Fornecedor fornecedor = fornecedorService.findById(produto.getIdFornecedor());
		
		Categoria categoria = catService.findById(produto.getIdCategoria());
		
		produto.setCategoria(categoria);
		produto.setFornecedor(fornecedor);
		
		return repository.save(produto);
	}
	
	public List<Produto> findAll() {
		return repository.findAll();
	}
	
	public Produto findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundError("Produto não encontrado!"));
	}
	
	public void delete(Long id) {
		Produto produto = findById(id);
		repository.delete(produto);
	}

	public Produto update(Produto produto, Long id) {
		Produto newProduto = findById(id);
		
		BeanUtils.copyProperties(produto, newProduto);
		
		newProduto.setId(id);
		
		return newProduto;
	}
	
}
