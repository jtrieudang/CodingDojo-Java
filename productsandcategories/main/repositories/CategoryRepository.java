package com.codingdojo.productsandcategories.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.productsandcategories.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}