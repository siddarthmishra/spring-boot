package com.siddarthmishra.springboot.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.siddarthmishra.springboot.api.entity.IntroducerDetails;

@Repository
public interface IntroducerRepository extends JpaRepository<IntroducerDetails, String>, JpaSpecificationExecutor<IntroducerDetails> {

}
