package com.siddarthmishra.springboot.dto;

import java.time.LocalDate;

public record IntroducerDTO(String spid, String partyId, LocalDate effectiveDate, LocalDate expiryDate) {

}
