package com.shop.cart.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.UUID;

public record OrderItemDTO(

        @UUID
        String id,

        @NotBlank(message = "Product id cannot be blank")
        String productId,

        @NotNull(message = "Quantity cannot be null")
        Integer quantity,

        @NotBlank(message = "Order id cannot be blank")
        String orderId
) {
}
