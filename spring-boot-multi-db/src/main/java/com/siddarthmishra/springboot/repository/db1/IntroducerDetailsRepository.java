package com.siddarthmishra.springboot.repository.db1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siddarthmishra.springboot.entity.db1.IntroducerDetails;

@Repository
public interface IntroducerDetailsRepository extends JpaRepository<IntroducerDetails, String> {

}
