package com.karma.practice.collection.operationandfactories;

import java.util.Collections;
import java.util.List;

import com.karma.practice.common.Product;
import com.karma.practice.common.Shipment;

public class ShipmentBreaker {

	private static Product door = new Product(1, "PlyWood", 100);
	private static Product window = new Product(2, "Glass Window", 48);
	private static Product bed = new Product(3, "Double Bed", 35);

	public static void main(String[] args) {
		Shipment shipment = new Shipment();
		
		shipment.add(door);
		shipment.add(window);
		shipment.add(door);
		shipment.add(window);
		shipment.add(bed);
		
		shipment.prepare();
		
		//this Function will make that unmodifiable so it will we will not able to change collection
		List<Product> lightVanProducts =shipment.getLightVanWeight();
        System.out.println("lightVanProducts = " + lightVanProducts);

        lightVanProducts.remove(window);
        System.out.println();
        System.out.println("shipment = " + shipment.getLightVanWeight());
        System.out.println();
        shipment.forEach(prod -> System.out.println(prod));
	}

}
