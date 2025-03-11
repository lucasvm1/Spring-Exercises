package com.lucasvm.Library_CRUD.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserDto(@NotBlank String name, @NotBlank @Email String email, @NotBlank @Size(min = 7, max = 20) String phone, @NotBlank String address) {
}
