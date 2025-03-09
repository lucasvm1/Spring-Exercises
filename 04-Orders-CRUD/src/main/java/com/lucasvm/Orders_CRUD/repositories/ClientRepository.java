package com.lucasvm.Orders_CRUD.repositories;

import com.lucasvm.Orders_CRUD.models.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<ClientModel, UUID> {
}
