package com.lucasvm.Library_CRUD.controllers;

import com.lucasvm.Library_CRUD.dtos.AuthorDto;
import com.lucasvm.Library_CRUD.models.AuthorModel;
import com.lucasvm.Library_CRUD.repositories.AuthorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @PostMapping
    public ResponseEntity<Object> addAuthor(@RequestBody @Valid AuthorDto AuthorDto) {
        var author = new AuthorModel();
        BeanUtils.copyProperties(AuthorDto, author);
        return ResponseEntity.created(URI.create("/authors/" + author.getId())).body(authorRepository.save(author));
    }

    @GetMapping
    public ResponseEntity<Object> getAllAuthors() {
        return ResponseEntity.ok(authorRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAuthorById(@PathVariable UUID id) {
        Optional<AuthorModel> author = authorRepository.findById(id);
        if (author.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(author.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAuthor(@PathVariable UUID id, @RequestBody @Valid AuthorDto AuthorDto) {
        Optional<AuthorModel> author = authorRepository.findById(id);
        if (author.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var authorUpdated = author.get();
        BeanUtils.copyProperties(AuthorDto, authorUpdated, "id");
        return ResponseEntity.ok().body(authorRepository.save(authorUpdated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAuthor(@PathVariable UUID id) {
        Optional<AuthorModel> author = authorRepository.findById(id);
        if (author.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        authorRepository.delete(author.get());
        return ResponseEntity.noContent().build();
    }

}
