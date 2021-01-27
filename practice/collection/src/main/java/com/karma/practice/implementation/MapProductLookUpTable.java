package com.karma.practice.implementation;

import java.util.HashMap;
import java.util.Map;

import com.karma.practice.common.Product;
import com.karma.practice.interfaces.ProductLookUpTable;

public class MapProductLookUpTable implements ProductLookUpTable {

	private Map<Integer, Product> idToProduct = new HashMap<>();

	@Override
	public Product lookUpId(int id) {
		return idToProduct.get(id);
	}

	@Override
	public void addProduct(Product productToAdd) {
		if (idToProduct.containsKey(productToAdd.getId())) {
			throw new IllegalArgumentException("cannot add Duplicate product" + productToAdd);
		}
		idToProduct.put(productToAdd.getId(), productToAdd);
	}

	@Override
	public void clear() {
		idToProduct.clear();
	}

}
