package com.example.cricEcom.ResponsDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PaymentResponseDto(Long id,
        Long userId,
        BigDecimal amount,
        Long orderId,
        String gatewayOrderId,
        String gatewayPaymentId,
        String signature,
        String status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {

}
