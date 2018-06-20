package com.manzuraz.productscategories.controllers;

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

import com.manzuraz.productscategories.models.Category;
import com.manzuraz.productscategories.models.Product;
import com.manzuraz.productscategories.services.PCService;

@Controller
public class PCController {
	
	private final PCService myservice;
	
	public PCController(PCService S) {
		this.myservice=S;
	}
	
	@RequestMapping("/")
	public String home(Model m) {
		List<Product> allproducts = myservice.all_products();
		m.addAttribute("productslist", allproducts);
		List<Category> allcategories = myservice.all_categories();
		m.addAttribute("categorieslist", allcategories);
		return "dashboard.jsp";
	}
	
	@RequestMapping("/products/new")
	public String newProduct(Model m, @ModelAttribute("product") Product p) {
		return "newproduct.jsp";
	}
	
	@PostMapping("/products/create")
	public String createProduct(Model m, @Valid @ModelAttribute("product") Product p, BindingResult res) {
		if(res.hasErrors()) {
			return "newproduct.jsp";
		}
		myservice.add_product(p);
		return "redirect:/";
	}
	
	@RequestMapping("/categories/new")
	public String newCategory(Model m, @ModelAttribute("category") Category c) {
		return "newcategory.jsp";
	}
	
	@PostMapping("/categories/create")
	public String createCategory(Model m, @Valid @ModelAttribute("category") Category c, BindingResult res) {
		if(res.hasErrors()) {
			return "newcategory.jsp";
		}
		myservice.add_category(c);
		return "redirect:/";
	}
	
	@RequestMapping("/categories/{id}")
	public String showCategory(Model m, @PathVariable("id") Long id) {
		m.addAttribute("productslist", myservice.all_products());
		m.addAttribute("category", myservice.findCategoryById(id));
		return "showcategory.jsp";
	}
	
	@PostMapping("/categories/{id}/add_product")
	public String addProductToCategory(Model m, @RequestParam("product_id") Long product_id, @PathVariable("id") Long category_id) {
		Category c = myservice.findCategoryById(category_id);
		Product p = myservice.findProductById(product_id);
		myservice.add_category_to_product(p, c);
		return "redirect:/categories/{id}";
	}
	
	@RequestMapping("/products/{id}")
	public String showProduct(Model m, @PathVariable("id") Long id) {
		m.addAttribute("categorieslist", myservice.all_categories());
		m.addAttribute("product", myservice.findProductById(id));
		return "showproduct.jsp";
	}
	
	@PostMapping("/products/{id}/add_category")
	public String addCategoryToProduct(Model m, @RequestParam("category_id") Long category_id, @PathVariable("id") Long product_id) {
		Category c = myservice.findCategoryById(category_id);
		Product p = myservice.findProductById(product_id);
		myservice.add_product_to_category(c,p);
		return "redirect:/products/{id}";
	}
	
}
