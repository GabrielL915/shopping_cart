package com.shop.cart.domain.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.UUID;

public record ProductDTO(

        @UUID
        String id,

        @NotBlank(message = "Name cannot be null")
        String name,

        Double price
) {
}
