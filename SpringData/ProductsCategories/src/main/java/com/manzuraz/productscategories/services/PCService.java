package com.manzuraz.productscategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.manzuraz.productscategories.models.Category;
import com.manzuraz.productscategories.models.Product;
import com.manzuraz.productscategories.repositories.CategoryRepository;
import com.manzuraz.productscategories.repositories.ProductRepository;

@Service
public class PCService {
	private final ProductRepository pr;
	private final CategoryRepository cr;
	
	public PCService(ProductRepository pr, CategoryRepository cr) {
		this.pr=pr;
		this.cr=cr;
	}
	
	public List<Product> all_products(){
		return pr.findAll();
	}
	
	public List<Category> all_categories(){
		return cr.findAll();
	}
	
	public Product findProductById(Long id) {
		return pr.findById(id).get();
	}
	
	public Category findCategoryById(Long id) {
		return cr.findById(id).get();
	}
	
	public void add_product(Product p){
		pr.save(p);
	}
	
	public void add_category(Category c){
		cr.save(c);
	}
	
	public void add_category_to_product(Product p, Category c){
		p.addCategories(c);
		pr.save(p);
	}
	
	public void add_product_to_category(Category c, Product p){
		c.addProducts(p);
		cr.save(c);
	}
}
