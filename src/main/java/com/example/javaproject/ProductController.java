package com.example.javaproject;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.javaproject.entitiy.Product;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    // Método para salvar um novo produto
    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product) {
        product.setCriationDate(LocalDateTime.now()); // Define a data de criação
        Product savedProduct = service.save(product);
        return ResponseEntity.status(201).body(savedProduct); // Retorna 201 Created
    }

    // Método para buscar todos os produtos
    @GetMapping
    public ResponseEntity<List<Product>> get() {
        List<Product> products = service.get();
        return ResponseEntity.ok(products); // Retorna 200 OK com a lista de produtos
    }

    // Método para deletar um produto pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content
    }

    // Método para atualizar um produto existente
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Integer id, @RequestBody Product product) {
        Product updatedProduct = service.update(id, product);
        return ResponseEntity.ok(updatedProduct); // Retorna 200 OK com o produto atualizado
    }
}
