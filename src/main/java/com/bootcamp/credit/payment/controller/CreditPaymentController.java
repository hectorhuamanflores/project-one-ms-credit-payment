package com.bootcamp.credit.payment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.credit.payment.dto.CreditPaymentByIdCreditRequest;
import com.bootcamp.credit.payment.dto.CreditPaymentByIdPaymentRequest;
import com.bootcamp.credit.payment.entity.CreditPayment;
import com.bootcamp.credit.payment.service.CreditPaymentService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/CreditPayment")
public class CreditPaymentController {

	private final CreditPaymentService creditPaymentService;

    @GetMapping
    public Mono<ResponseEntity<Flux<CreditPayment>>>getAllCreditPayment() {
        Flux<CreditPayment> list=this.creditPaymentService.getAllCreditPayment();
        return  Mono.just(ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(list));
    }

    @PostMapping("/idCreditPayment")
    public Mono<ResponseEntity<CreditPayment>> getCreditPaymentById(@RequestBody CreditPaymentByIdPaymentRequest creditPaymentByIdRequest){
        var Credit=this.creditPaymentService.getCreditPaymentById(creditPaymentByIdRequest.getIdCreditPayment());
        return Credit.map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    
    @PostMapping("/idCredit")
    public Mono<ResponseEntity<Flux<CreditPayment>>> getCreditPaymentByIdCredit(@RequestBody CreditPaymentByIdCreditRequest creditPaymentByIdCreditRequest){
    	
    	Flux<CreditPayment> list=this.creditPaymentService.getCreditPaymentByIdCredit(creditPaymentByIdCreditRequest.getIdCredit());
        return  Mono.just(ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(list));
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CreditPayment> create(@RequestBody CreditPayment Credit){
        return this.creditPaymentService.createCreditPayment(Credit);
    }

    @PutMapping("/updateCreditPayment")
    public Mono<ResponseEntity<CreditPayment>> updateCredit(@RequestBody CreditPayment Credit){

        return this.creditPaymentService.updateCreditPayment(Credit)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteCreditById(@PathVariable String id){
        return this.creditPaymentService.deleteCreditPayment(id)
                .map(r -> ResponseEntity.ok().<Void>build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    
   
}
