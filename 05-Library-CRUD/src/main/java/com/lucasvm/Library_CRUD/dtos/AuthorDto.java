package com.lucasvm.Library_CRUD.dtos;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record AuthorDto(@NotBlank @Size(min = 3, max = 100) String name, @NotBlank @Size(max = 256) String biography, @NotBlank @Size(min = 2, max = 2) String nationality, @NotNull @Past LocalDate birthDate) {
}
