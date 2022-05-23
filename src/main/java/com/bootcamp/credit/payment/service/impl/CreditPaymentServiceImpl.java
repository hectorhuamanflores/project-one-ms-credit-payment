package com.bootcamp.credit.payment.service.impl;

import java.util.function.Function;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.bootcamp.credit.payment.dto.CreditUpdateForConsPayRequest;
import com.bootcamp.credit.payment.dto.CreditUpdateForConsPayResponse;
import com.bootcamp.credit.payment.entity.CreditPayment;
import com.bootcamp.credit.payment.repository.CreditPaymentRepository;
import com.bootcamp.credit.payment.service.CreditPaymentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreditPaymentServiceImpl implements CreditPaymentService{
	private  final CreditPaymentRepository creditPaymentRepository;
    
	private WebClient creditServiceClient = WebClient.builder()
		      .baseUrl("http://localhost:8095")
		      .build();
	
	private Function<CreditUpdateForConsPayRequest, Mono<CreditUpdateForConsPayResponse>> msCreditForConsPay = (objeto) -> creditServiceClient.put()
			.uri("/CreditLine/updateCreditConsumptionPayment/")
			.body(Mono.just(objeto), CreditUpdateForConsPayResponse.class)
			.retrieve()
			.bodyToMono(CreditUpdateForConsPayResponse.class);
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
    	
    	CreditUpdateForConsPayRequest creditUpdateForConsPay = CreditUpdateForConsPayRequest.builder()
    			.idCredit(creditPayment.getIdCredit())
    			.type(creditPayment.getTyTrxCredit())
    			.amount(creditPayment.getAmountTrx())
    			.build();
    	
    	return msCreditForConsPay.apply(creditUpdateForConsPay).
    			flatMap(ra ->creditPaymentRepository.save(creditPayment));
        
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
