package com.onlineshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshop.entity.ProductEntity;
import com.onlineshop.repository.ProductRepository;
import com.onlineshop.service.IProductService;



@Service
public class ProductService implements IProductService{
	@Autowired
	ProductRepository productRepository;
	
	public ProductEntity createProduct(ProductEntity product) {
		try {
			// check
			List<ProductEntity> tempProduct = productRepository.findOneByNameSizeColor(product.getName(), product.getSize(), product.getColor());
			if (tempProduct != null) {
				return null;
			}

			// create new product
			product.setId(null);

			productRepository.save(product);
			return product;
		} catch (Exception ex) {
			System.out.println(ex.toString());
			return null;
		}
	}
	
	@Override
	public ProductEntity updateProduct(ProductEntity product, Long id) {
		ProductEntity productCurrent = productRepository.findOneById(id);
		if (productCurrent == null)
			return null;
		//to update
		productCurrent.setName(product.getName());
		productCurrent.setColor(product.getColor());
		productCurrent.setDescription(product.getDescription());
		productCurrent.setEvaluate(product.getEvaluate());
		productCurrent.setPrice(product.getPrice());
		productCurrent.setSize(product.getSize());
		productCurrent.setTotal(product.getTotal());
		
		ProductEntity productUpdate = productRepository.save(productCurrent);
		return productUpdate;
	}
	
	@Override
	public List<ProductEntity> SearchProduct(String size, String color){
		try {
			
			List<ProductEntity> listProduct = productRepository.findAllBySizeAndColor(size, color);
			return listProduct;
		} catch (Exception ex) {
			System.out.println(ex.toString());
			return null;
		}
	}
}
