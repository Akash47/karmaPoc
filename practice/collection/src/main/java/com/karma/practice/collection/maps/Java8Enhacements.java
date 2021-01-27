package com.karma.practice.collection.maps;

import java.util.HashMap;
import java.util.Map;

import com.karma.practice.common.Product;
import com.karma.practice.common.ProductFixture;

public class Java8Enhacements {

	public static void main(String[] args) {
		Product defaultProd = new Product(-1, "Whatever customer wants", 188);

		final Map<Integer, Product> products = new HashMap<Integer, Product>();
		products.put(ProductFixture.door.getId(), ProductFixture.door);
		products.put(ProductFixture.bed.getId(), ProductFixture.bed);
		products.put(ProductFixture.window.getId(), ProductFixture.window);

		Product product = products.getOrDefault(4, defaultProd);
		System.out.println(product);
		System.out.println(products.get(4));
		System.out.println();

		// replace value in maps
//		Product oldValue = products.replace(1, new Product(1, "Big Door", 200));
//		System.out.println(oldValue);
//		System.out.println(products.get(1));

		// Replace all value inside maps.
		System.out.println("Replace all weifht value inside maps");
		System.out.println(products);
		products.replaceAll((id, prod) -> {
			return new Product(id, prod.getName(), prod.getWeight() + 20);
		});
		System.out.println(products);
		System.out.println();

		// compute if absent.
		System.out.println("add a value it is absent with the help of compute if absent");
		Product aProduct = products.computeIfAbsent(3, id -> new Product(id, "Door Handle", 5));
		System.out.println(aProduct);
		System.out.println();
		
		products.forEach((id,prod)->{
			System.out.println(prod);
		});
			
	}

}
