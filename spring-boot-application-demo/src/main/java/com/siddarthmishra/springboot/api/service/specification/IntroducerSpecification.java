package com.siddarthmishra.springboot.api.service.specification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.siddarthmishra.springboot.api.constants.CommonConstants;
import com.siddarthmishra.springboot.api.entity.IntroducerDetails;
import com.siddarthmishra.springboot.api.entity.IntroducerDetails_;

import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Predicate;

// https://docs.spring.io/spring-data/jpa/reference/jpa/specifications.html
public interface IntroducerSpecification {

	public static Specification<IntroducerDetails> isExpiryDateGreaterThanOrEqual(LocalDate localDate) {
		return (root, query, criteriaBuilder) -> {
			// 1 => Root is your table.
			// 2 => CriteriaQuery is your query, good for applying distinct, sub-queries, order by, etc.
			// 3 => CriteriaBuilder is your conditions, good for creating your where clauses
			/**
			 * JPA Criteria Metamodel is used here.
			 * https://vladmihalcea.com/spring-data-jpa-specification/
			 * https://vladmihalcea.com/jpa-criteria-metamodel/
			 */
			return criteriaBuilder.greaterThanOrEqualTo(root.get(IntroducerDetails_.expiryDate), localDate);

			/**
			 * Below is WITHOUT JPA Criteria Metamodel. Directly use the variable name from
			 * the entity
			 */

			/*
			 * return criteriaBuilder.greaterThanOrEqualTo(root.get("expiryDate"),
			 * localDate);
			 */

		};
	}

	public static Specification<IntroducerDetails> isExpiryDateLessThanOrEqual(LocalDate localDate) {
		return (root, query, criteriaBuilder) -> {
			// 1 => Root is your table.
			// 2 => CriteriaQuery is your query, good for applying distinct, sub-queries, order by, etc.
			// 3 => CriteriaBuilder is your conditions, good for creating your where clauses
			criteriaBuilder.lessThanOrEqualTo(root.get("expiryDate"), localDate);
			/**
			 * JPA Criteria Metamodel is used here.
			 * https://vladmihalcea.com/spring-data-jpa-specification/
			 * https://vladmihalcea.com/jpa-criteria-metamodel/
			 */
			return criteriaBuilder.lessThanOrEqualTo(root.get(IntroducerDetails_.expiryDate), localDate);

			/**
			 * Below is WITHOUT JPA Criteria Metamodel. Directly use the variable name from
			 * the entity
			 */

			/*
			 * return criteriaBuilder.lessThanOrEqualTo(root.get("expiryDate"), localDate);
			 */

		};
	}

	public static Specification<IntroducerDetails> getIntroducerSpecifications(LocalDate expiryFrom, LocalDate expiryTo,
			String orderByExpiry) {
		return (root, query, criteriaBuilder) -> {
			// 1 => Root is your table.
			// 2 => CriteriaQuery is your query, good for applying distinct, sub-queries, order by, etc.
			// 3 => CriteriaBuilder is your conditions, good for creating your where clauses

			// add filter i.e. where clause in form of a Predicate
			List<Predicate> predicates = new ArrayList<>();
			// add sort i.e. order by condition to CriteriaQuery
			List<Order> orders = new ArrayList<>();
			if (expiryFrom != null && expiryTo != null) {
				// adds 'where' condition when dates are not null
				predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("expiryDate"), expiryFrom));
				predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("expiryDate"), expiryTo));
			}
			if (CommonConstants.ASC.equals(orderByExpiry)) {
				orders.add(criteriaBuilder.asc(root.get("expiryDate")));
			} else {
				orders.add(criteriaBuilder.desc(root.get("expiryDate")));
			}
			orders.add(criteriaBuilder.asc(root.get("creationDate")));
			query.orderBy(orders);
			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		};
	}
}
