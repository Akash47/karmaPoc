package com.karma.practice.collection.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.karma.practice.common.Product;

public class CollectionConcepts {
	public static void main(String[] args) {
		Product door = new Product(1,"PlyWood", 100);
		Product window = new Product(2,"Glass Window", 50);
		Product bed = new Product(3,"Double Bed", 35);

		Collection<Product> products = new ArrayList<Product>();
		products.add(door);
		products.add(window);
		products.add(bed);

		// System.out.println(products);

		/*
		 * //THis code will throw Concurrent modification error for (Product product :
		 * products) { if (product.getWeight() < 50) { products.remove(product); } }
		 */

		// To solve that issue we will use Iterator
		Iterator<Product> aProductIterator = products.iterator();
		while (aProductIterator.hasNext()) {
			if (aProductIterator.next().getWeight() > 50) {
				aProductIterator.remove();
			}

		}
		// print list of product
		System.out.println(products);
		// print the size of product list
		System.out.println(products.size());
		// check weather list is empty or not
		System.out.println(products.isEmpty());
		// check weather list contain window object or not
		System.out.println(products.contains(window));
		// if list contain window then it will remove from list and
		System.out.println(products.remove(window));
		// check weather list contain window object or not
		System.out.println(products.contains(window));

		// Adding a new collection to test remove all functionality.
		Collection<Product> toRemove = new ArrayList<Product>();
		toRemove.add(door);
		toRemove.add(window);
		toRemove.add(bed);
		System.out.println(toRemove);
		// This method will remove all the obj present in products from toRemoveList
		toRemove.removeAll(products);
		System.out.println(toRemove);

	}

}
