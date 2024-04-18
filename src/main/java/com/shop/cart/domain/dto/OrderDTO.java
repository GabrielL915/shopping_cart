package com.shop.cart.domain.dto;

import com.shop.cart.utils.enums.OrderStatus;
import jakarta.validation.constraints.NotBlank;
import jdk.jfr.Timestamp;
import org.hibernate.validator.constraints.UUID;

import java.time.LocalDateTime;

public record OrderDTO(

        @UUID
        String id,

        @Timestamp
        LocalDateTime createdAt,

        @NotBlank(message = "Customer id cannot be blank")
        String customerId,

        @NotBlank(message = "Status cannot be blank")
        OrderStatus status
) {
}
