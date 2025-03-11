package com.lucasvm.Library_CRUD.repositories;

import com.lucasvm.Library_CRUD.models.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<AuthorModel, UUID> {
}
