package com.karma.practice.collection.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.karma.practice.common.Product;

public class StreamProduct {

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

		// namesOfLightProductWeightSortedLoop(products);
		namesOfLightProductWeightSortedStream(products);
	}

	private static void namesOfLightProductWeightSortedStream(List<Product> products) {
		products
		.stream()
		.filter(prod -> prod.getWeight() < 51)
		.sorted(Comparator.comparingInt(Product::getWeight))
		.map(Product::getName)
		.forEach(System.out::println);
	}

	private static void namesOfLightProductWeightSortedLoop(List<Product> products) {
		List<Product> lightProductList = new ArrayList<>();
		for (Product product : products) {
			if (product.getWeight() < 51) {
				lightProductList.add(product);
			}
		}
		lightProductList.sort(Comparator.comparingInt(Product::getWeight));
		for (Product product : lightProductList) {
			System.out.println(product.getName());
		}
	}
}
