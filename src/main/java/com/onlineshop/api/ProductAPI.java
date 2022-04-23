package com.onlineshop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlineshop.entity.ProductEntity;

import com.onlineshop.service.impl.ProductService;

@CrossOrigin
@RestController
public class ProductAPI {
	
	@Autowired
	ProductService productService;
	
	//create new User
	@PostMapping(value="/product")
	public ProductEntity createProduct(@RequestBody ProductEntity product) {
		product = productService.createProduct(product);
		return product;
	}
	
	@PutMapping(value = "/product/{id}")
	public ProductEntity updateProduct(@RequestBody ProductEntity product, @PathVariable("id") Long id) {
		return productService.updateProduct(product, id);
	}
	
	@GetMapping(value = "/product/search/{size}/{color}")
	public List<ProductEntity> searchProduct(@PathVariable("size") String size, @PathVariable("color") String color){
		return productService.SearchProduct(size, color);
	}
}
