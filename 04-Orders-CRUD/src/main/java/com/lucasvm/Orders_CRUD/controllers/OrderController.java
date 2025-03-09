package com.lucasvm.Orders_CRUD.controllers;

import com.lucasvm.Orders_CRUD.dtos.OrderDto;
import com.lucasvm.Orders_CRUD.dtos.OrderProductDto;
import com.lucasvm.Orders_CRUD.models.ClientModel;
import com.lucasvm.Orders_CRUD.models.OrderModel;
import com.lucasvm.Orders_CRUD.models.OrderProductModel;
import com.lucasvm.Orders_CRUD.models.ProductModel;
import com.lucasvm.Orders_CRUD.repositories.ClientRepository;
import com.lucasvm.Orders_CRUD.repositories.OrderProductRepository;
import com.lucasvm.Orders_CRUD.repositories.OrderRepository;
import com.lucasvm.Orders_CRUD.repositories.ProductsRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private OrderProductRepository orderProductRepository;

    @PostMapping("/orders")
    public ResponseEntity<Object> create(@RequestBody @Valid OrderDto orderDto) {
        Optional<ClientModel> client = clientRepository.findById(orderDto.clientId());
        if (client.isEmpty()) {
            return ResponseEntity.badRequest().body("Cliente não encontrado!");
        }

        OrderModel order = new OrderModel();
        order.setClient(client.get());
        order.setTotal(0.0);

        order = orderRepository.save(order);

        List<OrderProductModel> orderProducts = new ArrayList<>();
        double total = 0.0;

        for (OrderProductDto productDto : orderDto.products()) {
            Optional<ProductModel> product = productsRepository.findById(productDto.productId());
            if (product.isEmpty()) {
                orderRepository.delete(order);
                return ResponseEntity.badRequest().body("Produto não encontrado: " + productDto.productId());
            }

            OrderProductModel orderProduct = new OrderProductModel();
            orderProduct.setProduct(product.get());
            orderProduct.setQuantity(productDto.quantity());
            orderProduct.setOrder(order);

            orderProducts.add(orderProduct);
            total += product.get().getPrice() * productDto.quantity();
        }

        orderProductRepository.saveAll(orderProducts);

        order.setTotal(total);
        order.setOrderProducts(orderProducts);
        order = orderRepository.save(order);

        return ResponseEntity.created(URI.create("/orders/" + order.getId())).body(order);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderModel>> getAllOrders() {
        return ResponseEntity.ok(orderRepository.findAll());
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Object> getOrderById(@PathVariable UUID id) {
        Optional<OrderModel> order = orderRepository.findById(id);
        if (order.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(order.get());
    }
}