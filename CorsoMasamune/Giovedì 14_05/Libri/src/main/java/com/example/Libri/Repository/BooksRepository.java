package com.example.Libri.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Libri.Model.Book;

import java.util.Optional;
import java.util.List;
import com.example.Libri.Model.Genre;
// interfaccia  BooksRepository
public interface BooksRepository extends JpaRepository<Book, Integer> {
    // metodo per recuperare un libro
    List<Book> findByTitle(String title);
    // metodo per recuperare tutti i libri
    List<Book> findAll();
    // metodo per recuperare un libro con un determinato id
    Optional<Book> findById(int id);
    // metodo per controllare se un libro esiste per id
    boolean existsById(int id);
    //metodo per controllare se un libro esiste per titolo
    boolean existsByTitle(String title);
    // cerca libri per autore
    List<Book> findByAuthor(String author);
    // cerca libri per isbn
    List<Book> findByIsbn(String isbn);
    //trova per genere
    List<Book> findByGenre(Genre genre);
    //trova per numero di pagine maggiore di
    List<Book> findByPagesGreaterThan(int pages);
    
}
