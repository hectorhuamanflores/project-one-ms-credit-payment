package com.bootcamp.credit.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditUpdateForConsPayRequest {
	
	private String idCredit;
	private Integer type;
	private Double amount;
	
}
