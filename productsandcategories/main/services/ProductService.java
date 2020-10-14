package com.codingdojo.productsandcategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.productsandcategories.models.Product;
import com.codingdojo.productsandcategories.repositories.CategoryRepository;
import com.codingdojo.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	public ProductService(ProductRepo productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}
	public void addProduct(Product product) {
		productRepository.save(product);
	}
	public List<Product> getAll(){
		return (List<Product>) productRepository.findAll();
	}
	public Product getOne(Long id) {
		return productRepository.findOne(id);
	}
	public void update(Product product) {
		productRepository.save(product);
	}
	public List<Product> getAllExcept(Long categoryId) {
		List<Product> products = this.getAll();
		List<Product> categoryProducts = categoryRepository.findOne(categoryId).getProducts();
		products.removeAll(categoryProducts);
		return products;
	}
}