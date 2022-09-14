package lf.melo.com.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "TB_FORNECEDOR")
public class Fornecedor extends Pessoa {

	@Column
	private String cnpj;
	
	@OneToMany(mappedBy = "fornecedor")
	@JsonIgnore
	private List<Produto> produtos;

	public Fornecedor() {
	}
	

	public Fornecedor(String cnpj) {
		super();
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
	
}
