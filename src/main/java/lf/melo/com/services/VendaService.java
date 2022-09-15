package lf.melo.com.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lf.melo.com.entities.Produto;
import lf.melo.com.entities.Usuario;
import lf.melo.com.entities.Venda;
import lf.melo.com.entities.dtos.VendaDTO;
import lf.melo.com.repositories.VendaRepository;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository repository;
	
	@Autowired
	private ProdutoService prodService;
	
	@Autowired
	private UsuarioService usuarioService;

	public List<Venda> findAll() {
		return repository.findAll();
	}
	
	public Venda findById(Long id) {
		return repository.findById(id).get();
	}
	
	
	public Venda create(VendaDTO dto) {
		
		Usuario usuario = usuarioService.findById(dto.getIdUsuario());
		
		BigDecimal valorCalculado = new BigDecimal(0.0);
		
		ArrayList<Produto> produtos = new ArrayList<>();
		
		dto.getIdProdutos().stream().forEach((Long idProduto) -> {
			Produto produto = prodService.findById(idProduto);
			produtos.add(produto);
			
			valorCalculado.add(produto.getPreco());
		});
		
			
		Venda venda = new Venda();
		
		venda.setProdutos(produtos);
		venda.setUsuario(usuario);
		venda.setValor(valorCalculado);
		venda.setDataVenda(LocalDateTime.now());
		
		return repository.save(venda);
	}
	
	
}
