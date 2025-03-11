package com.lucasvm.Library_CRUD.repositories;

import com.lucasvm.Library_CRUD.models.LoanModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoanRepository extends JpaRepository<LoanModel, UUID> {
}
