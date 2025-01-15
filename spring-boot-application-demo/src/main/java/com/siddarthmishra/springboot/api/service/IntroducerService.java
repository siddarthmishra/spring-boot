package com.siddarthmishra.springboot.api.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.siddarthmishra.springboot.api.constants.CommonConstants;
import com.siddarthmishra.springboot.api.constants.ErrorConstants;
import com.siddarthmishra.springboot.api.entity.IntroducerDetails;
import com.siddarthmishra.springboot.api.repository.IntroducerRepository;
import com.siddarthmishra.springboot.api.service.specification.IntroducerSpecification;
import com.siddarthmishra.springboot.api.validation.RequestValidator;

@Service
public class IntroducerService {

	@Autowired
	private IntroducerRepository introducerRepository;

	public IntroducerDetails getIntroducerById(String spid) {
		return introducerRepository.getReferenceById(spid);
	}

	public IntroducerDetails saveIntroducer(IntroducerDetails introducerDetails) {
		introducerDetails.setCreationDate(LocalDateTime.now());
		if (introducerDetails.getEffectiveDate() == null) {
			introducerDetails.setEffectiveDate(LocalDate.now());
		}
		if (introducerDetails.getExpiryDate() == null) {
			introducerDetails.setExpiryDate(introducerDetails.getEffectiveDate().plusYears(1L));
		}
		return introducerRepository.saveAndFlush(introducerDetails);
	}

	public List<IntroducerDetails> findAllIntroducers(String expiryFrom, String expiryTo, Integer pageNumber,
			Integer pageSize, String orderByExpiry) {
		RequestValidator.validateExpiryRequestParam(expiryFrom, expiryTo);
		orderByExpiry = RequestValidator.validateSortBy(orderByExpiry);
		Page<IntroducerDetails> introducerDetails;
		LocalDate expiryDateFrom = null;
		if (expiryFrom != null) {
			expiryDateFrom = RequestValidator.parse(expiryFrom, CommonConstants.FORMATTER_YYYYMMDD,
					ErrorConstants.INVALID_DATE_FORMAT_CD_001, ErrorConstants.INVALID_DATE_FORMAT_MSG_001,
					HttpStatus.BAD_REQUEST, expiryFrom, CommonConstants.YYYYMMDD);
		}
		LocalDate expiryDateTo = null;
		if (expiryTo != null) {
			expiryDateTo = RequestValidator.parse(expiryTo, CommonConstants.FORMATTER_YYYYMMDD,
					ErrorConstants.INVALID_DATE_FORMAT_CD_001, ErrorConstants.INVALID_DATE_FORMAT_MSG_001,
					HttpStatus.BAD_REQUEST, expiryTo, CommonConstants.YYYYMMDD);
		}

		// introducerDetails = wayOneOfFindAll(expiryDateFrom, expiryDateTo,
		// orderByExpiry, pageNumber, pageSize);
		introducerDetails = wayTwoOfFindAll(expiryDateFrom, expiryDateTo, orderByExpiry, pageNumber, pageSize);
		return introducerDetails.getContent();
	}

	/**
	 * This is the another way of fetching all the introducer using Specification
	 * and Pageable.
	 * <li>Specification are built from a list of
	 * 'jakarta.persistence.criteria.Predicate' for filter and and list of
	 * 'jakarta.persistence.criteria.Order' for sort.</li>
	 * <li>Pagable object is built only using 'pageNumber' and 'pageSize'. Sort is
	 * not included here.</li>
	 */
	@SuppressWarnings("unused")
	private Page<IntroducerDetails> wayTwoOfFindAll(LocalDate expiryDateFrom, LocalDate expiryDateTo,
			String orderByExpiry, Integer pageNumber, Integer pageSize) {
		Page<IntroducerDetails> introducerDetails;
		Specification<IntroducerDetails> specification = IntroducerSpecification
				.getIntroducerSpecifications(expiryDateFrom, expiryDateTo, orderByExpiry);
		Pageable pageable = PageRequest.of(pageNumber.intValue(), pageSize.intValue());
		introducerDetails = introducerRepository.findAll(specification, pageable);
		return introducerDetails;
	}

	/**
	 * This is one way of fetching all the introducer using Specification and
	 * Pageable.
	 * <li>Specifications are built one each at a time. One for
	 * 'greaterThanOrEqualTo' and another for 'lessThanOrEqualTo'. Both are combined
	 * using 'and'.</li>
	 * <li>Pagable object is built using 'pageNumber' and 'pageSize'. Sort object is
	 * also added to Pagable object.</li>
	 */
	@SuppressWarnings("unused")
	private Page<IntroducerDetails> wayOneOfFindAll(LocalDate expiryDateFrom, LocalDate expiryDateTo,
			String orderByExpiry, Integer pageNumber, Integer pageSize) {
		Page<IntroducerDetails> introducerDetails;
		Pageable pageable = getPageable(pageNumber, pageSize, orderByExpiry);
		if (expiryDateFrom != null && expiryDateTo != null) {
			introducerDetails = introducerRepository.findAll(getSpecifications(expiryDateFrom, expiryDateTo), pageable);
		} else {
			introducerDetails = introducerRepository.findAll(pageable);
		}
		return introducerDetails;
	}

	/**
	 * Used in method 'wayOneOfFindAll'. Gets the Specification.
	 */
	private Specification<IntroducerDetails> getSpecifications(LocalDate expiryDateFrom, LocalDate expiryDateTo) {
		return IntroducerSpecification.isExpiryDateGreaterThanOrEqual(expiryDateFrom)
				.and(IntroducerSpecification.isExpiryDateLessThanOrEqual(expiryDateTo));
	}

	/**
	 * Used in method 'wayOneOfFindAll'. Gets the Pageable object.
	 */
	private Pageable getPageable(Integer pageNumber, Integer pageSize, String orderByExpiry) {
		// https://www.baeldung.com/spring-data-jpa-pagination-sorting
		Sort expiryDateSort = Sort.by("expiryDate");
		expiryDateSort = CommonConstants.ASC.equals(orderByExpiry) ? expiryDateSort.ascending()
				: expiryDateSort.descending();
		Sort creationDateSort = Sort.by("creationDate").ascending();
		Sort finalSort = expiryDateSort.and(creationDateSort);
		Pageable pageable = PageRequest.of(pageNumber.intValue(), pageSize.intValue(), finalSort);
		return pageable;
	}
}
