package com.example.rizzboys.repos;

import com.example.rizzboys.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByCode(String code);

    @Query("select pr from Product pr where pr.id = :productId")
    Product findProductById(Long productId);
    @Query("select pr from Product pr where pr.name like :criterion or pr.description like :criterion")
    List<Product> searchInCatalog(String criterion);
}