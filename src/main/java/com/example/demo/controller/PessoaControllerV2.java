package com.example.demo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.filter.PessoaFilterV2;
import com.example.demo.dto.req.PessoaReqV2;
import com.example.demo.dto.res.PessoaResV2;
import com.example.demo.service.PessoaServiceV2;

@RestController
@RequestMapping("/api/pessoasv2")
public class PessoaControllerV2 {

	@Autowired
	private PessoaServiceV2 pessoaService;

	@GetMapping
	public Page<PessoaResV2> index(Optional<PessoaFilterV2> filter, @PageableDefault Pageable pageable) {
		return this.pessoaService.index(filter, pageable);
	}

	@GetMapping("/{id}")
	public Optional<PessoaResV2> show(@PathVariable Long id) {
		return this.pessoaService.show(id);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Long store(@Valid @RequestBody PessoaReqV2 dto) {
		return this.pessoaService.store(dto);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping("/{id}")
	public void update(@PathVariable Long id, @Valid @RequestBody PessoaReqV2 dto) {
		this.pessoaService.update(id, dto);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void destroy(@PathVariable Long id) {
		this.pessoaService.destroy(id);
	}
}