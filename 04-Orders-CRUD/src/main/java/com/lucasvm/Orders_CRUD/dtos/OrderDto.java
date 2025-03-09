package com.lucasvm.Orders_CRUD.dtos;

import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

public record OrderDto(
        @NotNull UUID clientId,
        @NotNull List<OrderProductDto> products
) {}

