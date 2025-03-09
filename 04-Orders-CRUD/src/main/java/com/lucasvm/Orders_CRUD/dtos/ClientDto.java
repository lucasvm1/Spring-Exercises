package com.lucasvm.Orders_CRUD.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ClientDto(@NotBlank @Size(min = 3, max = 100) String name, @NotBlank @Email String email, @NotBlank @Size(min = 8, max = 20) String phone, @NotBlank String address) {
}
