package com.lucasvm.Orders_CRUD.repositories;

import com.lucasvm.Orders_CRUD.models.OrderProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderProductRepository extends JpaRepository<OrderProductModel, UUID> {
}
