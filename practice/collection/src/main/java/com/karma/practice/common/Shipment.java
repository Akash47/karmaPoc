package com.karma.practice.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Shipment implements Iterable<Product> {
	public static final int LIGHT_MAX_VAN_WEIGHT = 49;

	private final List<Product> productCollection = new ArrayList<Product>();
	
	private  List<Product> lightVanWeight = new ArrayList<Product>();
	private  List<Product> heavyVanWeight = new ArrayList<Product>();

	public void add(Product pProduct) {
		productCollection.add(pProduct);
	}

	public boolean replace(Product oldProduct, Product newProduct) {
		int index = productCollection.indexOf(oldProduct);
		if (index == -1) {
			return false;
		} else {
			productCollection.set(index, newProduct);
			return true;
		}
	}
	
	public void prepare() {
		productCollection.sort(Product.BY_WEIGHT);
		
		int index = findSplitPoint();
		
		lightVanWeight= Collections.unmodifiableList(productCollection.subList(0, index));
		heavyVanWeight=  Collections.unmodifiableList(productCollection.subList(index, productCollection.size()));
	}

	private int findSplitPoint() {
		int size = productCollection.size();
		for (int i = 0; i < size; i++) {
			if(productCollection.get(i).getWeight()>LIGHT_MAX_VAN_WEIGHT) {
				return i;
			}			
		}
		return 0;
	}

	public Iterator<Product> iterator() {
		return productCollection.iterator();
	}

	public List<Product> getLightVanWeight() {
		return lightVanWeight;
	}

	public void setLightVanWeight(List<Product> lightVanWeight) {
		this.lightVanWeight = lightVanWeight;
	}

	public List<Product> getHeavyVanWeight() {
		return heavyVanWeight;
	}

	public void setHeavyVanWeight(List<Product> heavyVanWeight) {
		this.heavyVanWeight = heavyVanWeight;
	}
}
