package com.karma.practice.collection.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MutableHashMapKey {

	public static void main(String[] args) {
		final Map<MutableString, String> brokenMap = new HashMap<>();
		final String value = "abc";
		
		final MutableString key = new MutableString(value);
		brokenMap.put(key, value);
		System.out.println(brokenMap.get(key));
		System.out.println(brokenMap);
		System.out.println(brokenMap.hashCode());
		
		key.setValue("def");
		//never change the keep the key which are mutable t will break hash code and it will give wrong answer.
		System.out.println(brokenMap.get(key));
		System.out.println(brokenMap);
		System.out.println(brokenMap.hashCode());
		
	}
	private static class MutableString {
				
		@Override
		public String toString() {
			return  value;
		}

		private String value;
		
		public String getValue() {
			return value;
		}

		public void setValue(final String value) {
			Objects.requireNonNull(value);
			this.value = value;
		}

		public MutableString(final String value) {
			this.value = value;
		}

		@Override
		public int hashCode() {
			return value.hashCode();
		}
		
		@Override
		public boolean equals(final Object o) {
			if(this == o) return true;
			if(o == null|| getClass()!=o.getClass()) return false;
			
			final MutableString that = (MutableString) o;
			
			return value.equals(that.value);
		}

	}
}

