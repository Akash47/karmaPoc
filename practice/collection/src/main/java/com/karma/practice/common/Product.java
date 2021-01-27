package com.karma.practice.common;

import java.util.Comparator;


public class Product {
	private int id;
	
	private String name;
	private int weight;

	
	public Product(int id, String name, int weight) {
		super();
		this.id = id;
		this.name = name;
		this.weight = weight;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", weight=" + weight + "]";
	}



	public static final Comparator<Product> BY_WEIGHT = Comparator.comparingInt(Product::getWeight);
}
