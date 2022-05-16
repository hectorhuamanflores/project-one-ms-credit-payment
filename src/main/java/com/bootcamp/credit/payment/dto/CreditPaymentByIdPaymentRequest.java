package com.bootcamp.credit.payment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditPaymentByIdPaymentRequest {
	
   private String idCreditPayment;
   private Integer currency;
}
