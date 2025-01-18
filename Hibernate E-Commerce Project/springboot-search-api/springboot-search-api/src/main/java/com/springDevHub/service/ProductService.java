package com.springDevHub.service;

import com.springDevHub.entity.Product;
import com.springDevHub.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public List<Product> searchProduct(String query1, String query2){
        return productRepository.findAllByNameOrDescriptionContaining(query1, query2);
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }
}
