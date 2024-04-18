package com.shop.cart.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.UUID;

public record ProductDTO(

        @UUID
        String id,

        @NotBlank(message = "Name cannot be blank")
        String name,

        @NotNull(message = "Price cannot be null")
        Double price
) {
}
