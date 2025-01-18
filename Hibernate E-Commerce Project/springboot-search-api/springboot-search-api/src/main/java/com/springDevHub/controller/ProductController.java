package com.springDevHub.controller;

import com.springDevHub.entity.Product;
import com.springDevHub.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> searchProduct(@RequestBody Product product){
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @GetMapping("/{query1}/{query2}")
    public ResponseEntity<List<Product>> searchProduct(@PathVariable String query1, @PathVariable String query2 ){
        return ResponseEntity.ok(productService.searchProduct(query1, query2));
    }


}
