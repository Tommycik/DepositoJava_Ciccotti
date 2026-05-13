package com.example.demo.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.example.demo.RestController.ProductController;
import org.springframework.http.HttpStatus;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// controller rest per gestire i prodotti
@RestController("/api/products")
public class ProductController {
    private List<String > products = new ArrayList<>();
    // inizializzazione dei dati
    @PostConstruct
    public void init(){
        products.add("product1");
        products.add("product2");
        products.add("product3");
    }
    // get generico
    @GetMapping()
    public ResponseEntity<List<String>> getProducts(){
        return ResponseEntity.ok(products);
    }
    // get singolo
    @GetMapping("/{id}")
    public ResponseEntity<String> getProduct(@PathVariable Integer id){
        //controllo id e lista
        if(id>products.size() || id<0 || products.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
    // crea singolo prodotto
    @PostMapping()
    public ResponseEntity<String> addProduct(@RequestBody String product){
        products.add(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
    // aggiorna singolo prodotto
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Integer id, @RequestBody String product){
        //controllo id e lista
        if(id>products.size() || id<0 || products.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        int index = products.indexOf(id);
        products.set(index, product);
        return ResponseEntity.ok().build();
    }
    // elimina singolo prodotto
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id){
        //controllo id e lista
        if(id>products.size() || id<0 || products.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        int index = products.indexOf(id);
        products.remove(index);
        return ResponseEntity.ok().build();
    }
    
    
}
