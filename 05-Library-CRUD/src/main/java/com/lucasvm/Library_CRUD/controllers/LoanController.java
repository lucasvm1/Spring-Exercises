package com.lucasvm.Library_CRUD.controllers;

import com.lucasvm.Library_CRUD.dtos.LoanDto;
import com.lucasvm.Library_CRUD.enums.LoanStatus;
import com.lucasvm.Library_CRUD.models.BookModel;
import com.lucasvm.Library_CRUD.models.LoanModel;
import com.lucasvm.Library_CRUD.models.UserModel;
import com.lucasvm.Library_CRUD.repositories.BookRepository;
import com.lucasvm.Library_CRUD.repositories.LoanRepository;
import com.lucasvm.Library_CRUD.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    LoanRepository loanRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    UserRepository userRepository;

    @PostMapping
    public ResponseEntity<Object> addLoan(@RequestBody @Valid LoanDto loanDto) {
        Optional<BookModel> book = bookRepository.findById(loanDto.bookId());
        Optional<UserModel> user = userRepository.findById(loanDto.userId());
        if (book.isEmpty() || user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        if (!book.get().isAvailable()) {
            return ResponseEntity.badRequest().body("The book is not available for loan.");
        }

        var loan = new LoanModel();
        loan.setBook(book.get());
        loan.setUser(user.get());
        loan.setStatus(LoanStatus.ACTIVE);

        book.get().setAvailable(false);
        bookRepository.save(book.get());

        var savedLoan = loanRepository.save(loan);
        return ResponseEntity.created(URI.create("/loans/" + savedLoan.getId())).body(savedLoan);
    }


    @GetMapping
    public ResponseEntity<Object> getAllLoans() {
        return ResponseEntity.ok(loanRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getLoanById(@PathVariable UUID id) {
        Optional<LoanModel> loan = loanRepository.findById(id);
        if (loan.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(loan.get());
    }

    @PutMapping("/{id}/return")
    public ResponseEntity<Object> returnLoan(@PathVariable UUID id) {
        Optional<LoanModel> loan = loanRepository.findById(id);
        if (loan.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var book = loan.get().getBook();

        if (loan.get().getStatus() == LoanStatus.RETURNED) {
            return ResponseEntity.badRequest().body("The book has already been returned previously!");
        }

        loan.get().setStatus(LoanStatus.RETURNED);
        book.setAvailable(true);
        loan.get().setReturnDate(LocalDate.now());
        bookRepository.save(book);

        return ResponseEntity.ok(loanRepository.save(loan.get()));


    }

}
