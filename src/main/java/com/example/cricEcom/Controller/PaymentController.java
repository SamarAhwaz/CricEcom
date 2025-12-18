package com.example.cricEcom.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cricEcom.RequestDto.PaymentConfirmRequestDto;
import com.example.cricEcom.RequestDto.PaymentInitiatedRequestDto;
import com.example.cricEcom.ResponsDto.PaymentInitiatedResponseDto;
import com.example.cricEcom.Service.PaymentService;

import lombok.RequiredArgsConstructor;


@CrossOrigin("*")
@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {


	


	    private final PaymentService paymentService;

	    @PostMapping("/initiate")
	    public PaymentInitiatedResponseDto initiate(@RequestBody PaymentInitiatedRequestDto req) {
	        return paymentService.initiatePayment(req);
	    }

	    @PostMapping("/confirm")
	    public String confirm(@RequestBody PaymentConfirmRequestDto req) {
	        return paymentService.confirmPayment(req);
	    }}

