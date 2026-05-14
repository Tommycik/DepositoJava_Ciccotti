package com.example.Libri.Model;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity
@Table(name = "books") 
// entity per la classe Book
public class Book {
    // campi della tabella books
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title", nullable = false, length = 200)
    private String title;
    @Column(name = "author", length = 100)
    private String author;
    @Column(name = "isbn", nullable = false)
    private String isbn;
    @Column(name = "price", nullable = false)
    private double price;
    @Enumerated(EnumType.STRING)  
    @Column(name = "genre", nullable = false)
    private Genre genre;
    @Column(name = "pages", nullable = false)
    private int pages;
    
    // costruttore per jpa
    public Book() {
    }
    // costruttore per java
    public Book(String title, String author, String isbn, double price, Genre genre, int pages) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.genre = genre;
        this.pages = pages;
    }
    // getter e setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getIsbn() {
        return isbn;
    }
    public int getPages() {
        return pages;
    }
    public Genre getGenre() {
        return genre;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }   
    // metodo override di toString
    @Override
    public String toString() {
        return "Libri [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", price=" + price + "]";
    }
    
}
