package lf.melo.com.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity(name = "TB_FORNECEDOR")
public class Fornecedor extends Pessoa {

	@Column
	private String cpnj;
	
	@OneToMany(mappedBy = "fornecedor")
	private List<Produto> produtos;

	public Fornecedor(String cpnj) {
		super();
		this.cpnj = cpnj;
	}

	public String getCpnj() {
		return cpnj;
	}

	public void setCpnj(String cpnj) {
		this.cpnj = cpnj;
	}
	
}
