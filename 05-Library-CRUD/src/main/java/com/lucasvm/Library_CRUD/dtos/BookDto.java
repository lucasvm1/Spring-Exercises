package com.lucasvm.Library_CRUD.dtos;

import jakarta.validation.constraints.*;

import java.util.UUID;

public record BookDto(@NotBlank @Size(min = 3, max = 50) String title, @NotNull UUID authorId, @NotBlank String isbn, @NotBlank String genre, @Positive int year) {
}
