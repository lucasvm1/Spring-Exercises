package com.lucasvm.Library_CRUD.controllers;

import com.lucasvm.Library_CRUD.dtos.BookDto;
import com.lucasvm.Library_CRUD.models.AuthorModel;
import com.lucasvm.Library_CRUD.models.BookModel;
import com.lucasvm.Library_CRUD.repositories.AuthorRepository;
import com.lucasvm.Library_CRUD.repositories.BookRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;

    @PostMapping
    public ResponseEntity<Object> addBook(@RequestBody @Valid BookDto bookDto) {
        Optional<AuthorModel> author = authorRepository.findById(bookDto.authorId());
        if (author.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var bookModel = new BookModel();
        bookModel.setAuthor(author.get());
        BeanUtils.copyProperties(bookDto, bookModel);
        bookRepository.save(bookModel);

        List<BookModel> books = author.get().getBooks();

        books.add(bookModel);

        return ResponseEntity.created(URI.create("/books/" + bookModel.getId())).body(bookModel);

    }

    @GetMapping
    public ResponseEntity<Object> getBooks() {
        return ResponseEntity.ok(bookRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getBookById(@PathVariable UUID id) {
        Optional<BookModel> book = bookRepository.findById(id);
        if (book.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateBook(@PathVariable UUID id, @RequestBody @Valid BookDto bookDto) {
        Optional<BookModel> book = bookRepository.findById(id);
        Optional<AuthorModel> newAuthor = authorRepository.findById(bookDto.authorId());

        if (book.isEmpty() || newAuthor.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var bookModel = book.get();
        var newAuthorModel = newAuthor.get();

        AuthorModel oldAuthor = bookModel.getAuthor();
        if (oldAuthor != null && !oldAuthor.getId().equals(newAuthorModel.getId())) {

            oldAuthor.getBooks().remove(bookModel);

            newAuthorModel.getBooks().add(bookModel);
        }

        BeanUtils.copyProperties(bookDto, bookModel, "id");

        bookModel.setAuthor(newAuthorModel);

        return ResponseEntity.ok(bookRepository.save(bookModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable UUID id) {
        Optional<BookModel> book = bookRepository.findById(id);
        if (book.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var author = authorRepository.findById(book.get().getAuthor().getId());
        List<BookModel> bookList = author.get().getBooks();
        bookList.remove(book);

        bookRepository.delete(book.get());
        return ResponseEntity.noContent().build();

    }


}
