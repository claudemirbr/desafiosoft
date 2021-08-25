package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo.dto.filter.PessoaFilterV2;
import com.example.demo.dto.req.PessoaReqV2;
import com.example.demo.dto.res.PessoaResV2;
import com.example.demo.model.Pessoa;
import com.example.demo.repository.PessoaRepository;
import com.example.demo.specs.PessoaSpecsV2;

@Service
public class PessoaServiceV2 {

	@Autowired
	private PessoaRepository pessoaRepository;

	private Pessoa save(Pessoa pessoa) {
		return this.pessoaRepository.save(pessoa);
	}

	public Page<PessoaResV2> index(Optional<PessoaFilterV2> filter, Pageable pageable) {
		Specification<Pessoa> spec = PessoaSpecsV2.specByFilter(filter);
		return this.pessoaRepository.findAll(spec, pageable).map(PessoaResV2::new);
	}

	public Optional<PessoaResV2> show(Long id) {
		return this.pessoaRepository.findById(id).map(PessoaResV2::new);
	}

	public Long store(PessoaReqV2 dto) {
		Pessoa pessoa = dto.toModel(new Pessoa());
		pessoa = this.save(pessoa);
		return pessoa.getId();
	}

	public void update(Long id, PessoaReqV2 dto) {
		Pessoa pessoa = dto.toModel(this.pessoaRepository.findById(id).get());
		this.save(pessoa);
	}

	public void destroy(Long id) {
		this.pessoaRepository.deleteById(id);
	}
}
