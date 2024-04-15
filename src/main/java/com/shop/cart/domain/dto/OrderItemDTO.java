package com.shop.cart.domain.dto;

public record OrderItemDTO(
        String id,

        String productId,

        Integer quantity,

        String orderId
) {
}
