package com.example.demo.specs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo.dto.filter.PessoaFilter;
import com.example.demo.model.Pessoa;
import com.example.demo.model.Pessoa_;

public class PessoaSpecs extends BaseSpecs {

	public static Specification<Pessoa> specByFilter(Optional<PessoaFilter> filter) {
		return filter.isEmpty() ? null : (root, query, builder) -> {
			Collection<Predicate> predicates = new ArrayList<>();

			predicates.add(equal(builder, root.get(Pessoa_.ID), filter.map(PessoaFilter::getId)));
			predicates.add(contains(builder, root.get(Pessoa_.NOME), filter.map(PessoaFilter::getNome)));
			predicates.add(contains(builder, root.get(Pessoa_.CPF), filter.map(PessoaFilter::getCpf)));

			Expression<String> allCols = concatAll(builder, root.get(Pessoa_.ID), root.get(Pessoa_.NOME),
					root.get(Pessoa_.CPF));
			predicates.add(contains(builder, allCols, filter.map(PessoaFilter::getAny)));
			return toAndArray(builder, predicates);
		};
	}
}