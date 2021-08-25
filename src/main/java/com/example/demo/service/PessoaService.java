package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo.dto.filter.PessoaFilter;
import com.example.demo.dto.req.PessoaReq;
import com.example.demo.dto.res.PessoaRes;
import com.example.demo.model.Pessoa;
import com.example.demo.repository.PessoaRepository;
import com.example.demo.specs.PessoaSpecs;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	private Pessoa save(Pessoa pessoa) {
		return this.pessoaRepository.save(pessoa);
	}

	public Page<PessoaRes> index(Optional<PessoaFilter> filter, Pageable pageable) {
		Specification<Pessoa> spec = PessoaSpecs.specByFilter(filter);
		return this.pessoaRepository.findAll(spec, pageable).map(PessoaRes::new);
	}

	public Optional<PessoaRes> show(Long id) {
		return this.pessoaRepository.findById(id).map(PessoaRes::new);
	}

	public Long store(PessoaReq dto) {
		Pessoa pessoa = dto.toModel(new Pessoa());
		pessoa = this.save(pessoa);
		return pessoa.getId();
	}

	public void update(Long id, PessoaReq dto) {
		Pessoa pessoa = dto.toModel(this.pessoaRepository.findById(id).get());
		this.save(pessoa);
	}

	public void destroy(Long id) {
		this.pessoaRepository.deleteById(id);
	}
}
