package com.nahuel.springjpaadvance.repository;

import com.nahuel.springjpaadvance.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
