package br.com.campanha.vo;

import java.util.List;

import javax.validation.constraints.NotNull;

public class CampanhaUsuarioVO {

	@NotNull(message="campo usuario é obrigatório")
	private Long usuario;

	@NotNull(message="lista de campanhas é obrigatória")
	private List<Long> campanhas;

	public CampanhaUsuarioVO() {
		// TODO Auto-generated constructor stub
	}

	public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}

	public List<Long> getCampanhas() {
		return campanhas;
	}

	public void setCampanhas(List<Long> campanhas) {
		this.campanhas = campanhas;
	}

}
