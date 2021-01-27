package com.karma.practice.interfaces;

import com.karma.practice.common.Product;

public interface ProductLookUpTable {
	
	Product lookUpId(int id);
	
	void addProduct(Product productToAdd);
	
	void clear();

}
