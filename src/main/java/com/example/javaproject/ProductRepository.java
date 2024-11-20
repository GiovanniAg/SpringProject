package com.example.javaproject;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.javaproject.entitiy.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    
}
