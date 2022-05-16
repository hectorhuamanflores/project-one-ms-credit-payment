package com.bootcamp.credit.payment.service;

import org.springframework.stereotype.Service;

import com.bootcamp.credit.payment.entity.CreditPayment;
import com.bootcamp.credit.payment.repository.CreditPaymentRepository;
import com.bootcamp.credit.payment.service.impl.CreditPaymentServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreditPaymentService implements CreditPaymentServiceImpl{
	private  final CreditPaymentRepository creditPaymentRepository;

    @Override
    public Flux<CreditPayment> getAllCreditPayment() {
        return creditPaymentRepository.findAll();
    }

    @Override
    public Mono<CreditPayment> getCreditPaymentById(String id) {
        return creditPaymentRepository.findById(id);
    }

    @Override
    public Mono<CreditPayment> createCreditPayment(CreditPayment creditPayment) {
    	if(creditPayment !=null) {
    		log.error("INICIO_CREACION_CREDIT");
    		log.info("idCredit: "+creditPayment.getIdCredit());
    		return creditPaymentRepository.save(creditPayment);
    	}else {
    		log.error("creditPayment is null");
    		throw new RuntimeException("creditPayment is null");
    	}
       
    }

    @Override
    public Mono<CreditPayment> updateCreditPayment(CreditPayment CreditPayment) {
    	
        
        return creditPaymentRepository.findById(CreditPayment.getId())
                .flatMap( object ->{
                	object.setIdCredit(CreditPayment.getIdCredit());
                	object.setTyTrxCredit(CreditPayment.getTyTrxCredit());
                	object.setCurrency(CreditPayment.getCurrency());
                	object.setAmountTrx(CreditPayment.getAmountTrx());
                	object.setDateStar(CreditPayment.getDateStar());
                    return creditPaymentRepository.save(object);
                 });
    }

    @Override
    public Mono<CreditPayment> deleteCreditPayment(String id) {
        return creditPaymentRepository.findById(id)
                .flatMap(existscreditPaymentRepository -> creditPaymentRepository.delete(existscreditPaymentRepository)
                        .then(Mono.just(existscreditPaymentRepository)));
    }

	@Override
	public Flux<CreditPayment> getCreditPaymentByIdCredit(String idCredit) {
		log.error("INICIO_CREDIT_CONSUMTION");
		log.info("idCredit: "+idCredit);
		return creditPaymentRepository.findByIdCredit(idCredit);
	}

	
}
