package com.shop.cart.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.UUID;

public record CustomerDTO(

        @UUID
        String id,

        @NotBlank(message = "Name cannot be blank")
        @Size(max = 100)
        String name,

        @NotBlank(message = "Email cannot be blank")
        @Email(message = "Must be a valid email")
        String email
) {
}
