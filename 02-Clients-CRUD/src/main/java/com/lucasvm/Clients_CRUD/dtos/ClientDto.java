package com.lucasvm.Clients_CRUD.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDate;

public record ClientDto(@NotNull @Size(min = 2) @Size(max = 100) String name,@Email String email, @NotNull LocalDate birthday) {
}
