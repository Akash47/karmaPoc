package com.karma.practice.collection.maps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.karma.practice.common.Product;
import com.karma.practice.implementation.MapProductLookUpTable;
import com.karma.practice.implementation.NativeProductLookUpTable;
import com.karma.practice.interfaces.ProductLookUpTable;

public class LookUpTableComparsion {

	private static final int ITERATIONS = 5;
	private static final int NUMBER_OF_PRODUCT = 20_000;

	private static final List<Product> products = generateProduct();

	public static void main(String[] args) {
		runLookUps(new NativeProductLookUpTable());
		runLookUps(new MapProductLookUpTable());
	}

	private static void runLookUps(final ProductLookUpTable lookupTable) {
		final List<Product> products = LookUpTableComparsion.products;

		System.out.println("Running LookUp with " + lookupTable.getClass().getSimpleName());
		
		 for (int i = 0; i < ITERATIONS; i++)
	        {
	            final long startTime = System.currentTimeMillis();

	            for (Product product : products)
	            {
	                lookupTable.addProduct(product);
	            }

	            for (Product product : products)
	            {
	                final Product result = lookupTable.lookUpId(product.getId());
	                if (result != product)
	                {
	                    throw new IllegalStateException("Lookup Table returned wrong result for " + product);
	                }
	            }

	            lookupTable.clear();

	            System.out.println(System.currentTimeMillis() - startTime + "ms");
	        }
	}

	private static List<Product> generateProduct() {
		final List<Product> products = new ArrayList<>();
		final Random weightGenerator = new Random();
		for (int i = 0; i < NUMBER_OF_PRODUCT; i++) {
			products.add(new Product(i, "Product" + i, weightGenerator.nextInt(100)));

		}
		Collections.shuffle(products);
		Collections.shuffle(products);
		Collections.shuffle(products);
		return products;
	}

}
