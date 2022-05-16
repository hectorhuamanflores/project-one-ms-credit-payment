package com.bootcamp.credit.payment.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Document(value = "PRODUCTS_CREDIT_PAYMENT")
public class CreditPayment {

    @Id
    private String  id;              // Identificador Credito Consumo
    private String  idCredit;        // Identificador del credito
    private Integer tyTrxCredit;     // 1:consumo  -1:pago
    private Integer currency;        // tipo de moneda
    private Double  amountTrx;       // monto de la transferencia
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dateStar;        // Fecha de creacion

}
