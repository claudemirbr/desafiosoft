package com.example.demo.dto.req;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.example.demo.model.Pessoa;

public class PessoaReqV2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5226179488708780949L;
	@NotBlank
	private String nome;
	private String sexo;
	private String email;
	private Date nascimento;
	private String naturalidade;
	private String nacionalidade;
	@NotBlank
	private String cpf;
	@NotBlank
	private String endereco;
	
	public Pessoa toModel(Pessoa pessoa) {
		pessoa.setNome(nome);
		pessoa.setSexo(sexo);
		pessoa.setEmail(email);
		pessoa.setNascimento(nascimento);
		pessoa.setNaturalidade(naturalidade);
		pessoa.setNacionalidade(nacionalidade);
		pessoa.setCpf(cpf);
		pessoa.setEndereco(endereco);
		return pessoa;
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

}
