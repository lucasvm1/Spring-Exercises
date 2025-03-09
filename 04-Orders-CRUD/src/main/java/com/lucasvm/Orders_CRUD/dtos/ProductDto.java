package com.lucasvm.Orders_CRUD.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record ProductDto(@NotBlank String description, @NotBlank String name , @Positive double price) {
}
