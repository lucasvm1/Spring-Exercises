package com.lucasvm.Library_CRUD.controllers;

import com.lucasvm.Library_CRUD.dtos.UserDto;
import com.lucasvm.Library_CRUD.models.UserModel;
import com.lucasvm.Library_CRUD.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody @Valid UserDto UserDto) {
        var user = new UserModel();
        BeanUtils.copyProperties(UserDto, user);
        return ResponseEntity.created(URI.create("/users/" + user.getId())).body(userRepository.save(user));
    }

    @GetMapping
    public ResponseEntity<Object> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUser(@PathVariable UUID id) {
        Optional<UserModel> user = userRepository.findById(id);
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable UUID id, @RequestBody @Valid UserDto UserDto) {
        Optional<UserModel> user = userRepository.findById(id);
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var userModel = user.get();
        BeanUtils.copyProperties(UserDto, userModel, "id", "registrationDate");
        return ResponseEntity.ok(userRepository.save(userModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable UUID id) {
        Optional<UserModel> user = userRepository.findById(id);
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
