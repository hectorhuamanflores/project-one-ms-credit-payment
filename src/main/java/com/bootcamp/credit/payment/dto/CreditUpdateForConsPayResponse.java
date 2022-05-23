package com.bootcamp.credit.payment.dto;

import java.time.LocalDate;

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
public class CreditUpdateForConsPayResponse {
	
	
    private String  id;              
    private Integer documentNumber;  
    private String  tyCredito;       
    private String  tyCustomer;      
    private LocalDate     dateStar;        
    private LocalDate     dateEnd;         
    private String  creditScore;     
	private Double  lineCredit;      
	private Double  consumeCredit;   
	private Double  availableCredit; 

}
