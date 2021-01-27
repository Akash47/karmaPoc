package com.karma.practice.collection.operationandfactories;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UnmodifiableVsImutable {

	public static void main(String[] args) {
		Map<String, Integer> mutableCountryToPopulation = new HashMap<String, Integer>();
		mutableCountryToPopulation.put("UK", 627);
		mutableCountryToPopulation.put("USA", 328);

		Map<String, Integer> UnmodifiableCountryToPopulation = Collections.unmodifiableMap(mutableCountryToPopulation);
		
		System.out.println(UnmodifiableCountryToPopulation);
		//if will try to manipulate  Unmodifiable collection then it will throw java.lang.UnsupportedOperationException
		//UnmodifiableCountryToPopulation.put("Germany", 892);
		
		//but instead of that if you add value in mutable object your 
		//Unmodifiable collection can be manipulated 

		mutableCountryToPopulation.put("Germany", 328);
		System.out.println(UnmodifiableCountryToPopulation);
		
		
	}

}
