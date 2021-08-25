package com.example.demo.specs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo.dto.filter.PessoaFilterV2;
import com.example.demo.model.Pessoa;
import com.example.demo.model.Pessoa_;

public class PessoaSpecsV2 extends BaseSpecs {

	public static Specification<Pessoa> specByFilter(Optional<PessoaFilterV2> filter) {
		return filter.isEmpty() ? null : (root, query, builder) -> {
			Collection<Predicate> predicates = new ArrayList<>();

			predicates.add(equal(builder, root.get(Pessoa_.ID), filter.map(PessoaFilterV2::getId)));
			predicates.add(contains(builder, root.get(Pessoa_.NOME), filter.map(PessoaFilterV2::getNome)));
			predicates.add(contains(builder, root.get(Pessoa_.CPF), filter.map(PessoaFilterV2::getCpf)));

			Expression<String> allCols = concatAll(builder, root.get(Pessoa_.ID), root.get(Pessoa_.NOME),
					root.get(Pessoa_.CPF));
			predicates.add(contains(builder, allCols, filter.map(PessoaFilterV2::getAny)));
			return toAndArray(builder, predicates);
		};
	}
}