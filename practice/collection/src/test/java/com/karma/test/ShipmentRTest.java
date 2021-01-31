package com.karma.test;



import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.karma.practice.common.Product;
import com.karma.practice.common.Shipment; 
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat; 

public class ShipmentRTest {
	private static Product door = new Product(1,"PlyWood", 100);
	private static Product window = new Product(2,"Glass Window", 50);
	private static Product bed = new Product(3,"Double Bed", 35);
	
	private Shipment aShipment = new Shipment();
	
	@Test
	public void shouldAddItems() {
		aShipment.add(door);
		aShipment.add(window);
		
		assertThat(aShipment,contains(door, window));
	}
	
	@Test
	public void shouldReplaceItem() {
		aShipment.add(door);
		aShipment.add(window);
		
		assertTrue(aShipment.replace(door, bed));
		assertThat(aShipment,contains(bed, window));
		
	}
	@Test
	public void shouldNotReplaceMissingItems() {
		aShipment.add(door);
		
		assertFalse(aShipment.replace(window, bed));
		assertThat(aShipment,contains(door));
		
	}
	@Test
	public void shouldIdentifyVanRequirement() {
		aShipment.add(door);
		aShipment.add(window);
		aShipment.add(bed);
		
		aShipment.prepare();
		
		assertThat(aShipment.getLightVanWeight(), contains(bed));
		assertThat(aShipment.getHeavyVanWeight(), contains(window,door));
	}
}
