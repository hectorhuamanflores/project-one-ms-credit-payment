package com.bootcamp.credit.payment.service;

import com.bootcamp.credit.payment.entity.CreditPayment;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditPaymentService {

    public Flux<CreditPayment> getAllCreditPayment();
    public Mono<CreditPayment> getCreditPaymentById(String id);
    public Flux<CreditPayment> getCreditPaymentByIdCredit(String idCredit);
    public Mono<CreditPayment> createCreditPayment(CreditPayment credit);
    public Mono<CreditPayment> updateCreditPayment(CreditPayment credit);
    public Mono<CreditPayment> deleteCreditPayment(String id);

}
