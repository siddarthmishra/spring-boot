package com.siddarthmishra.springboot.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siddarthmishra.springboot.api.entity.IntroducerActivityDetails;

@Repository
public interface IntroducerActivityRepository extends JpaRepository<IntroducerActivityDetails, String> {

	public List<IntroducerActivityDetails> findBySpid(String spid);
}
