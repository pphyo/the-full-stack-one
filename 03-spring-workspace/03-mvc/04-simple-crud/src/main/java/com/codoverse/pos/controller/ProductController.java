package com.codoverse.pos.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codoverse.pos.model.Product;
import com.codoverse.pos.service.ProductService;

@Controller
@RequestMapping("products")
public class ProductController {
	
	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	public String listProducts(Model model, @RequestParam(required = false) String keyword) {
		model.addAttribute("products", productService.search(keyword));
		return "product-list";
	}
	
	@GetMapping("form")
	public String showCreateForm(Model model) {
		model.addAttribute("product", new Product());
		return "product-form";
	}
	
	@GetMapping("form/{id}")
	public String showEditForm(Model model, @PathVariable Integer id) {
		var product = productService.findById(id);
		model.addAttribute("product", product);
		return "product-form";
	}
	
	@PostMapping
	public String saveProduct(RedirectAttributes redirect, @ModelAttribute Product product) {
		productService.save(product);
		String message = product.getId() == null || product.getId().equals(0) ? "Product saved successfully..." : "Product updated successfully...";
		redirect.addFlashAttribute("message", message);
		return "redirect:/products";
	}
	
	@GetMapping("delete/{id}")
	public String deleteProduct(RedirectAttributes redirect, @PathVariable Integer id) {
		productService.delete(id);
		redirect.addFlashAttribute("message", "Product deleted successfully...");
		return "redirect:/products";
	}
	
	@ModelAttribute
	public void intiCategories(Model model) {
		model.addAttribute("categories", Arrays.asList("Electronics", "Clothing", "Food", "Furniture"));
	}

}
