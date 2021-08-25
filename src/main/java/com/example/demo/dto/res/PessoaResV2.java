package com.example.demo.dto.res;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.example.demo.model.Pessoa;

public class PessoaResV2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3642217693910544174L;
	private Long id;
	private String nome;
	private String sexo;
	private String email;
	private Date nascimento;
	private String naturalidade;
	private String nacionalidade;
	private String cpf;
	private String endereco;
	private LocalDateTime createAt;
	private LocalDateTime updatedAt;

	public PessoaResV2() {

	}

	public PessoaResV2(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.sexo = pessoa.getSexo();
		this.email = pessoa.getEmail();
		this.nascimento = pessoa.getNascimento();
		this.naturalidade = pessoa.getNaturalidade();
		this.nacionalidade = pessoa.getNacionalidade();
		this.cpf = pessoa.getCpf();
		this.endereco = pessoa.getEndereco();
		this.createAt = pessoa.getCreateAt();
		this.updatedAt = pessoa.getUpdatedAt();
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}
