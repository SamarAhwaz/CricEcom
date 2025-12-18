package com.example.cricEcom.Service;

import com.example.cricEcom.RequestDto.PaymentConfirmRequestDto;
import com.example.cricEcom.RequestDto.PaymentInitiatedRequestDto;
import com.example.cricEcom.ResponsDto.OrderResponseDto;
import com.example.cricEcom.ResponsDto.PaymentInitiatedResponseDto;
import com.example.cricEcom.ResponsDto.PaymentResponseDto;

public interface PaymentService {

	

    PaymentInitiatedResponseDto initiatePayment(PaymentInitiatedRequestDto request);

    String confirmPayment(PaymentConfirmRequestDto request);

    PaymentResponseDto getPayment(Long id);
}
