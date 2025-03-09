package com.lucasvm.Orders_CRUD.controllers;

import com.lucasvm.Orders_CRUD.dtos.ClientDto;
import com.lucasvm.Orders_CRUD.models.ClientModel;
import com.lucasvm.Orders_CRUD.repositories.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @PostMapping("/clients")
    public ResponseEntity<Object> create(@RequestBody @Valid ClientDto clientDto) {
        var client = new ClientModel();
        BeanUtils.copyProperties(clientDto, client);
        return ResponseEntity.ok(clientRepository.save(client));
    }

    @GetMapping("/clients")
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.ok(clientRepository.findAll());
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Object> getById(@PathVariable UUID id) {
        Optional<ClientModel> client = clientRepository.findById(id);
        if (client.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client.get());
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<Object> update(@RequestBody @Valid ClientDto clientDto, @PathVariable UUID id) {
        Optional<ClientModel> client = clientRepository.findById(id);
        if (client.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        BeanUtils.copyProperties(clientDto, client.get(), "id");
        return ResponseEntity.ok().body(clientRepository.save(client.get()));

    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        Optional<ClientModel> client = clientRepository.findById(id);
        if (client.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        clientRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
