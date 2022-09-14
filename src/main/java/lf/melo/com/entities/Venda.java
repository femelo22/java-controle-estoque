package lf.melo.com.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(precision = 2)
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@JsonFormat(pattern = "dd/MM/yyyy: HH:mm")
	private LocalDateTime dataVenda;
	
	@ManyToMany
	@JoinTable(
	  name = "venda_produto", 
	  joinColumns = @JoinColumn(name = "venda_id"), 
	  inverseJoinColumns = @JoinColumn(name = "produto_id"))
	private List<Produto> produtos;
	
	
	
	public Venda() {
		
	}

	public Venda(BigDecimal valor, Usuario usuario, LocalDateTime dataVenda) {
		super();
		this.valor = valor;
		this.usuario = usuario;
		this.dataVenda = dataVenda;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDateTime getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDateTime dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	
	

}
