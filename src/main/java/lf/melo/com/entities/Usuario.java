package lf.melo.com.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Usuario extends Pessoa {
	
	@Column
	private String cpf;
	
	@Column
	private String username;
	
	@Column
	private String senha;
	
	@OneToMany(mappedBy = "usuario")
	private List<Venda> vendas;
	
	public Usuario() {
		
	}

	public Usuario(String cpf, String username, String senha) {
		super();
		this.cpf = cpf;
		this.username = username;
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [cpf=" + cpf + ", username=" + username + ", senha=" + senha + ", vendas=" + vendas + "]";
	}
	
	
	
	
}
