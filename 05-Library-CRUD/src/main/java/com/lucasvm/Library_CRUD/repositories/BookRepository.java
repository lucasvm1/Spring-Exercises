package com.lucasvm.Library_CRUD.repositories;

import com.lucasvm.Library_CRUD.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<BookModel, UUID> {
}
