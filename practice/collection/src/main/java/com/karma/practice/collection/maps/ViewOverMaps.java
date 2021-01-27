package com.karma.practice.collection.maps;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.karma.practice.common.Product;
import com.karma.practice.common.ProductFixture;

public class ViewOverMaps {

	public static void main(String[] args) {
		final Map<Integer, Product> products = new HashMap<Integer, Product>();
		products.put(ProductFixture.door.getId(), ProductFixture.door);
		products.put(ProductFixture.bed.getId(), ProductFixture.bed);
		products.put(ProductFixture.window.getId(), ProductFixture.window);
		Product bed = new Product(3,"Double Bed", 35);

		Set<Integer> ids = products.keySet();
		System.out.println("key set of Ids " + ids);
		System.out.println("products in map " + products);
		System.out.println();

		System.out.println("After removing value from key set it will remove from map");
		ids.remove(ProductFixture.door.getId());
		System.out.println("key set of Ids " + ids);
		System.out.println("products in map " + products);
		System.out.println();

		// we cannot add an entry without adding value in key set.
		// ids.add(5);

		Collection<Product> aProductCollection = products.values();
		System.out.println("values representation with collection interface " + aProductCollection);
		System.out.println("Value representation with maps "+products);
		System.out.println();
		System.out.println("After removing value from products collection");
		aProductCollection.remove(ProductFixture.window);
		System.out.println("values representation with collection interface " + aProductCollection);
		System.out.println("Value representation with maps "+products);
		System.out.println();
		
		//This is happening because we are using same object reffernce if it is not it will not remove that entry 
		//System.out.println(products.get(3).hashCode());
		//System.out.println(aProductCollection.iterator().next().hashCode());
		
		//LikeWise we cannot add a value without a key in any collection or key set.
		//aProductCollection.add(bed);
		
		//Entry Set
		System.out.println("Entry set");
		Set<Map.Entry<Integer, Product>> entries = products.entrySet();
		for (Entry<Integer, Product> entry : entries) {
			System.out.println(entry);
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			
			entry.setValue(ProductFixture.window);
		}
		System.out.println(entries);
		
		//Feature of java 9
//		 Map.Entry<Integer, Product> entry = Map.entry(1, ProductFixture.bed);
//	        entries.add(entry);
	}

}
