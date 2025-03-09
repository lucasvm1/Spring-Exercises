package com.lucasvm.Orders_CRUD.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public record OrderProductDto(@NotNull UUID productId, @Positive int quantity) {
}
