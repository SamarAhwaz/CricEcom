package com.example.cricEcom.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.cricEcom.ResponsDto.PaymentResponseDto;
import com.example.cricEcom.entities.Payment;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    @Mapping(target = "status", source = "status")
    PaymentResponseDto toDto(Payment payment);

}
