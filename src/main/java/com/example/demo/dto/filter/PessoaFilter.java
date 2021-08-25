package com.example.demo.dto.filter;

import java.io.Serializable;

public class PessoaFilter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 800554821291069730L;
	private Long id;
	private String nome;
	private String cpf;
	private String any;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getAny() {
		return any;
	}

	public void setAny(String any) {
		this.any = any;
	}

}
