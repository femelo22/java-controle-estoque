package lf.melo.com.entities.dtos;

import java.util.List;

public class VendaDTO {
	
	private Long idUsuario;
	
	private List<Long> idProdutos;
	
	public VendaDTO() {
		
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public List<Long> getIdProdutos() {
		return idProdutos;
	}

	public void setIdProdutos(List<Long> idProdutos) {
		this.idProdutos = idProdutos;
	}
	
	
	

}
