package com.lucasvm.Products_CRUD.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductDto(@NotBlank(message = "O nome não pode estar em branco!") String name, @Positive(message = "O preço deve ser positivo!") @NotNull(message = "O valor não pode estar em branco!")  BigDecimal price) {
}
