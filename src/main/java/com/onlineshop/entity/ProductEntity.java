package com.onlineshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="product")
public class ProductEntity extends BaseEntity{
	@Column(name = "name")
	private String name;
	
	@Column(name = "size")
	private String size;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "total")
	private int total;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "evaluate")
	private int evaluate;

	public ProductEntity() {
	    	
	}
	
	public ProductEntity(String name, String size, String color,
			String description, int total, int price, int evalue) {
		super();
		this.name = name;
		this.description = description;
		this.size = size;
		this.color = color;
		this.total = total;
		this.price = price;
		this.evaluate = evalue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(int evaluate) {
		this.evaluate = evaluate;
	}
	
	
	
	
	
}
