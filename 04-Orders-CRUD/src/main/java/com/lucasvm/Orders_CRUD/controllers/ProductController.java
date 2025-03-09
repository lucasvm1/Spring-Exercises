package com.lucasvm.Orders_CRUD.controllers;

import com.lucasvm.Orders_CRUD.dtos.ProductDto;
import com.lucasvm.Orders_CRUD.models.ProductModel;
import com.lucasvm.Orders_CRUD.repositories.ProductsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ProductController {

    @Autowired
    ProductsRepository productsRepository;

    @PostMapping("/products")
    public ResponseEntity<Object> create(@RequestBody @Valid ProductDto productDto) {
        var product = new ProductModel();
        BeanUtils.copyProperties(productDto, product);
        return ResponseEntity.ok(productsRepository.save(product));
    }

    @GetMapping("/products")
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.ok(productsRepository.findAll());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getById(@PathVariable UUID id) {
        Optional<ProductModel> product = productsRepository.findById(id);
        if (product.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product.get());
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> update(@PathVariable UUID id, @RequestBody @Valid ProductDto productDto) {
        Optional<ProductModel> product = productsRepository.findById(id);
        if (product.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        BeanUtils.copyProperties(productDto, product.get(), "id");
        return ResponseEntity.ok().body(productsRepository.save(product.get()));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        Optional<ProductModel> product = productsRepository.findById(id);
        if (product.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        productsRepository.delete(product.get());
        return ResponseEntity.noContent().build();
    }



}
