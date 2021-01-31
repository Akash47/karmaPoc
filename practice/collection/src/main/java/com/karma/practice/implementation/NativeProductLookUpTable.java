package com.karma.practice.implementation;

import java.util.ArrayList;
import java.util.List;

import com.karma.practice.common.Product;
import com.karma.practice.interfaces.ProductLookUpTable;

public class NativeProductLookUpTable implements ProductLookUpTable {

	private final List<Product> aProductList = new ArrayList<Product>();

	@Override
	public Product lookUpId(int id) {
		for (Product product : aProductList) {
			if (product.getId() == id) {
				return product;
			}
		}
		return null;
	}

	public void addProduct(Product productToAdd) {
		for (Product product : aProductList) {
			if (product.getId() == productToAdd.getId()) {
				throw new IllegalArgumentException("cannot add Duplicate product" + productToAdd);
			}
		}
		aProductList.add(productToAdd);
	}

	
	public void clear() {
		aProductList.clear();
	}

}
