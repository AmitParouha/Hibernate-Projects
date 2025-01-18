package com.springDevHub.repository;

import com.springDevHub.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

//    @Query("SELECT p from Product p WHERE p.name LIKE CONCAT('%', :query, '%') OR" +
//            "p.description LIKE CONCAT('%', :query, '%')")

    public List<Product> findAllByNameOrDescriptionContaining(String query1, String query2);
}
