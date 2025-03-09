package com.lucasvm.Orders_CRUD.repositories;

import com.lucasvm.Orders_CRUD.models.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderModel, UUID> {
}
