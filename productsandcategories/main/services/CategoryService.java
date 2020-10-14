package com.codingdojo.productsandcategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.productsandcategories.models.Category;
import com.codingdojo.productsandcategories.repositories.CategoryRepository;
import com.codingdojo.productsandcategories.repositories.ProductRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	public CategoryService(CategoryRepository categoryRepository, ProductRepository productRepository) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
	}
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}
	public List<Category> getAll() {
		return (List<Category>) categoryRepository.findAll();
	}
	public Category getOne(Long id) {
		return categoryRepository.findOne(id);
	}
	public void update(Category category) {
		categoryRepository.save(category);
	}
	public List<Category> getAllExcept(Long productId) {
		List<Category> categories = this.getAll();
		List<Category> productCategories = productRepository.findOne(productId).getCategories();
		categories.removeAll(productCategories);
		return categories;
	}
}