package com.codingdojo.productsandcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.productsandcategories.models.Category;
import com.codingdojo.productsandcategories.models.Product;
import com.codingdojo.productsandcategories.services.CategoryService;
import com.codingdojo.productsandcategories.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	private final ProductService productService;
	private final CategoryService categoryService;
	public ProductController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	@RequestMapping("/new")
	public String newProduct(Model model, @ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}
	@PostMapping("/new")
	public String add(@Valid @ModelAttribute("product") Product product, BindingResult result, RedirectAttributes errors) {
		if(result.hasErrors()) {
			errors.addFlashAttribute("errors", result.getAllErrors());
			return "redirect:/products/new";
		} else {
			productService.addProduct(product);
			return "redirect:/";
		}
	}
	@RequestMapping("/{id}")
	public String showCat(Model model, @PathVariable("id") Long id) {
		Product product = productService.getOne(id);
		model.addAttribute("product", product);
		model.addAttribute("categories", categoryService.getAllExcept(id));
		return "showProduct.jsp";
	}
	@PostMapping("/{id}")
	public String addProduct(@PathVariable("id") Long productId, @RequestParam("category") Long categoryId) {
		Product product = productService.getOne(productId);
		Category category = categoryService.getOne(categoryId);
		List<Category> categories = product.getCategories();
		categories.add(category);
		productService.update(product);
		return "redirect:/products/"+productId;
	}
}