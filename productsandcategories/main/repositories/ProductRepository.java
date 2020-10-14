package com.codingdojo.productsandcategories.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.productsandcategories.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}