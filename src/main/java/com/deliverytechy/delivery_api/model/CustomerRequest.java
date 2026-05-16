package com.deliverytechy.delivery_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CustomerRequest(
    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 100)
    String name,

    @NotBlank(message = "O e-mail é obrigatório")
    @Email(message = "E-mail inválido")
    String email,

    String phone,
    String address
) {}