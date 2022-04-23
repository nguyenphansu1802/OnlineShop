package com.onlineshop.service;

import java.util.List;

import com.onlineshop.entity.ProductEntity;

public interface IProductService {
	public ProductEntity createProduct(ProductEntity product);
	public ProductEntity updateProduct(ProductEntity product, Long id);
	public List<ProductEntity> SearchProduct(String size, String color);
}
