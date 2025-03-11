package com.lucasvm.Library_CRUD.dtos;

import com.lucasvm.Library_CRUD.enums.LoanStatus;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record LoanDto(@NotNull UUID userId, @NotNull UUID bookId, @FutureOrPresent LocalDate returnDate, LoanStatus loanStatus) {
}
