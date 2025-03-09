package com.lucasvm.Clients_CRUD.controllers;

import com.lucasvm.Clients_CRUD.dtos.ClientDto;
import com.lucasvm.Clients_CRUD.models.ClientModel;
import com.lucasvm.Clients_CRUD.repositories.ClientRepository;
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
        return ResponseEntity.ok().body(clientRepository.save(client));
    }

    @GetMapping("/clients")
    public ResponseEntity<Object> findAll() {
        return ResponseEntity.ok().body(clientRepository.findAll());
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Object> findById(@PathVariable UUID id) {
        Optional<ClientModel> client = clientRepository.findById(id);
        if (client.isPresent()) {
            return ResponseEntity.ok().body(client.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<Object> update(@RequestBody @Valid ClientDto clientDto, @PathVariable UUID id) {
        Optional<ClientModel> client = clientRepository.findById(id);
        if (client.isPresent()) {
            BeanUtils.copyProperties(clientDto, client.get(), "id");
            return ResponseEntity.ok().body(clientRepository.save(client.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        Optional<ClientModel> client = clientRepository.findById(id);
        if (client.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        clientRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
