package br.com.campanha.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Campanha extends BaseModel<Long> {

	@NotNull(message="Nome da campanha não pode ser vazio")
	private String nome;

	private Long idTime;

	@NotNull(message="Data de inicio de vigencia não pode ser vazia.")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataInicioVigencia;

	@NotNull(message="Data de fim de vigencia não pode ser vazia.")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataFimVigencia;

	
	@OneToMany(mappedBy="campanha")
	@JsonIgnore
	List<CampanhaUsuario> campanhasUsuario;
	
	public Campanha() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Long getIdTime() {
		return idTime;
	}

	public void setIdTime(Long idTime) {
		this.idTime = idTime;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataInicioVigencia() {
		return dataInicioVigencia;
	}

	public void setDataInicioVigencia(LocalDate dataInicioVigencia) {
		this.dataInicioVigencia = dataInicioVigencia;
	}

	public LocalDate getDataFimVigencia() {
		return dataFimVigencia;
	}

	public void setDataFimVigencia(LocalDate dataFimVigencia) {
		this.dataFimVigencia = dataFimVigencia;
	}

	public List<CampanhaUsuario> getCampanhasUsuario() {
		return campanhasUsuario;
	}

	public void setCampanhasUsuario(List<CampanhaUsuario> campanhasUsuario) {
		this.campanhasUsuario = campanhasUsuario;
	}


}
