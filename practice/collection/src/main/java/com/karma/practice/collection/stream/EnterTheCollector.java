package com.karma.practice.collection.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.karma.practice.common.Product;

public class EnterTheCollector {

	public static void main(String[] args) {
		Product door = new Product(1, "PlyWood", 100);
		Product window = new Product(2, "Glass Window", 50);
		Product bed = new Product(3, "Double Bed", 35);

		List<Product> products = new ArrayList<>();
		products.add(door);
		products.add(window);
		products.add(bed);
		products.add(door);
		products.add(window);
		
		List<Product> lightProductList =products
		.stream()
		.filter(prod -> prod.getWeight() < 51)
		.sorted(Comparator.comparingInt(Product::getWeight))
		.collect(Collectors.toList());
		
		System.out.println(lightProductList);
		
		//Return the list of object which are applicable for light products
		Map<String, List<Product>> lightProductMap =products
				.stream()
				.filter(prod -> prod.getWeight() < 51)
				.sorted(Comparator.comparingInt(Product::getWeight))
				.collect(Collectors.groupingBy(Product::getName));
		System.out.println(lightProductMap);
		
		//present the object counting
		Map<String, Long> lightProductMapCount = products
				.stream()
				.filter(prod -> prod.getWeight() < 51)
				.sorted(Comparator.comparingInt(Product::getWeight))
				.collect(Collectors.groupingBy(Product::getName,Collectors.counting()));
		System.out.println(lightProductMapCount);
	}

}
