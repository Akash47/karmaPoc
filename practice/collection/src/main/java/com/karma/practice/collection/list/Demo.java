package com.karma.practice.collection.list;

import java.util.Arrays;

import com.karma.practice.common.Product;

public class Demo {

	public static void main(String[] args) {
		Product door = new Product(1,"PlyWood", 100);
		Product window = new Product(2,"Glass Window", 50);
		Product bed = new Product(3,"Double Bed", 35);

		Product[] productArray = { door, window };
		System.out.println(Arrays.toString(productArray));
		
		//Add new value in array
		productArray = add(productArray, bed);
		System.out.println(Arrays.toString(productArray));

		// This will be adding a duplicate value in array
		productArray = add(productArray, bed);
		System.out.println(Arrays.toString(productArray));
	}

	private static Product[] add(Product[] productArray, Product window) {
		Product[] aProducts = Arrays.copyOf(productArray, productArray.length + 1);
		aProducts[productArray.length] = window;
		return aProducts;
	}

}
