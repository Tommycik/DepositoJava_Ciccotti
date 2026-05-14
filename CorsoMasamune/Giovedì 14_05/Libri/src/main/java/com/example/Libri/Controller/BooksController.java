package com.example.Libri.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import com.example.Libri.Model.Book;
import com.example.Libri.Model.Genre;
import com.example.Libri.Repository.BooksRepository;
//rest controller per gestire le operazioni CRUD sui libri
@RestController
@RequestMapping("/api/books")
public class BooksController {
    
    private final BooksRepository booksRepository;
    // costruttore
    public BooksController(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    //get mapping
    @GetMapping
    public List<Book> getBooks() {
        return booksRepository.findAll();
    }
    
    //get mapping per un determinato id
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        Optional<Book> book = booksRepository.findById(id);
        return book.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    //post mapping
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book newBook = booksRepository.save(book);
        return ResponseEntity.status(201).body(newBook);
    }
    //put mapping
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book) {
        Optional<Book> bookToUpdate = booksRepository.findById(id);
        if (bookToUpdate.isPresent()) {
            Book updatedBook = bookToUpdate.get();
            updatedBook.setTitle(book.getTitle());
            updatedBook.setAuthor(book.getAuthor());
            updatedBook.setIsbn(book.getIsbn());
            updatedBook.setPrice(book.getPrice());
            updatedBook.setPages(book.getPages());
            updatedBook.setGenre(book.getGenre());
            Book savedBook = booksRepository.save(updatedBook);
            return ResponseEntity.ok(savedBook);
        } else {
            return ResponseEntity.status(404).build();
        }
    }
    //delete mapping
    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable int id) {
        boolean exists = booksRepository.existsById(id);
        if (exists) {
            booksRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}
