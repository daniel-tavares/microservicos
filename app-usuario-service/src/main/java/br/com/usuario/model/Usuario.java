package br.com.usuario.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.usuario.enums.SituacaoAtivoInativoEnum;

@Entity
public class Usuario extends BaseModel<Long> {

	private String nome;

	private String email;
    
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

	private Long idTime;

	private SituacaoAtivoInativoEnum situacao;

	@PrePersist
	public void prePersist() {
		situacao = SituacaoAtivoInativoEnum.ATIVO;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Long getIdTime() {
		return idTime;
	}

	public void setIdTime(Long idTime) {
		this.idTime = idTime;
	}

	public SituacaoAtivoInativoEnum getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoAtivoInativoEnum situacao) {
		this.situacao = situacao;
	}

}
