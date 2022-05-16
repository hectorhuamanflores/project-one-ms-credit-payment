package com.bootcamp.credit.payment.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.credit.payment.entity.CreditPayment;

import reactor.core.publisher.Flux;

@Repository
public interface CreditPaymentRepository  extends ReactiveCrudRepository<CreditPayment,String> {
    /*
     * find(loQuetrae)By(loQueBusca)
     * findByNombreContainingOrApellidoContaining(String nombre,String apellido);
     * 
     */
	Flux<CreditPayment> findByIdCredit(String idCredit);
	
}
