package br.com.campanha.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class CampanhaUsuario extends BaseModel<Long> {

	@NotNull(message = "Identificador da campanha não pode ser vazia.")
	@ManyToOne
	@JoinColumn(name = "id_campanha")
	private Campanha campanha;

	@NotNull(message = "IdUsuario não pode ser vazia.")
	@Column(name = "id_usuario")
	private Long idUsuario;

	public Campanha getCampanha() {
		return campanha;
	}

	public void setCampanha(Campanha campanha) {
		this.campanha = campanha;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

}
