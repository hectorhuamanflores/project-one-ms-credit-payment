package com.bootcamp.credit.payment.service.impl;

import com.bootcamp.credit.payment.entity.CreditPayment;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditPaymentServiceImpl {

    public Flux<CreditPayment> getAllCreditPayment();
    public Mono<CreditPayment> getCreditPaymentById(String id);
    public Flux<CreditPayment> getCreditPaymentByIdCredit(String idCredit);
    public Mono<CreditPayment> createCreditPayment(CreditPayment credit);
    public Mono<CreditPayment> updateCreditPayment(CreditPayment credit);
    public Mono<CreditPayment> deleteCreditPayment(String id);

}
