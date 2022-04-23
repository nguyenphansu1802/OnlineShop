package com.onlineshop.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.onlineshop.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
	@Query(value = "SELECT c FROM ProductEntity c WHERE c.name LIKE %?1% AND c.size LIKE %?2% AND c.color LIKE %?3%")
	public List<ProductEntity> findOneByNameSizeColor(String productName, String size, String color);
	public ProductEntity findOneById(Long id);
	
	@Query(value = "SELECT c FROM ProductEntity c WHERE c.size LIKE %?1% OR c.color LIKE %?2%")
	public List<ProductEntity> findAllBySizeAndColor(String size, String color);
}
