package lf.melo.com.entities;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "TB_PRODUTO")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	@Column(precision = 2)
	private BigDecimal preco;
	
	@Column
	private int quantidade;
	
	@Column
	private int estoqueMin;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	
	@ManyToOne
	@JoinColumn(name = "fornecedor_id")
	private Fornecedor fornecedor;
	
	@ManyToMany(mappedBy = "produtos")
	@JsonIgnore
	private List<Venda> vendas;
	
	@JsonIgnore
	private Long idFornecedor;
	
	@JsonIgnore
	private Long idCategoria;

	
	public Produto() {
		
	}

	public Produto(String nome, BigDecimal preco, int quantidade, int estoqueMin, List<Venda> vendas, Long idFornecedor,
			Long idCategoria) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.estoqueMin = estoqueMin;
		this.vendas = vendas;
		this.idFornecedor = idFornecedor;
		this.idCategoria = idCategoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getEstoqueMin() {
		return estoqueMin;
	}

	public void setEstoqueMin(int estoqueMin) {
		this.estoqueMin = estoqueMin;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}


	public List<Venda> getVendas() {
		return vendas;
	}


	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}


	public Long getIdFornecedor() {
		return idFornecedor;
	}


	public void setIdFornecedor(Long idFornecedor) {
		this.idFornecedor = idFornecedor;
	}


	public Long getIdCategoria() {
		return idCategoria;
	}


	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

}
