package com.lucasvm.Orders_CRUD.repositories;

import com.lucasvm.Orders_CRUD.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductsRepository extends JpaRepository<ProductModel, UUID> {
}
