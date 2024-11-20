package com.example.javaproject;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.javaproject.entitiy.Product;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    // Método para salvar um produto
    public Product save(Product product) {
        return repository.save(product);
    }

    // Método para buscar todos os produtos
    public List<Product> get() {
        return repository.findAll();
    }

    // Método para deletar um produto pelo ID
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    // Método para atualizar um produto
    public Product update(Integer id, Product productDetails) {
        Product existingProduct = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + id));

        // Atualiza os campos permitidos
        existingProduct.setName(productDetails.getName());
        existingProduct.setDescription(productDetails.getDescription());
        existingProduct.setPrice(productDetails.getPrice());
        existingProduct.setQuantityStock(productDetails.getQuantityStock());
        existingProduct.setCategory(productDetails.getCategory());
        existingProduct.setUpdateDate(new java.util.Date());

        return repository.save(existingProduct);
    }
}

