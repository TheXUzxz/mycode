package com.cy.company.java.oop.feature;

import java.util.LinkedHashMap;

class SimpleLruCahche extends LinkedHashMap<Object, Object>{
		
		private int max;
		public SimpleLruCahche(int i) {
			super(i, (float) 0.75, true);
			this.max=i;
			
		}
		@Override
		protected boolean removeEldestEntry(
				java.util.Map.Entry<Object, Object> eldest) {
		 
		if (size()>max) {
			return true;
		}
		
		return false;
		}
	
}
public class TestLruCache {
	public static void main(String[] args) {
		SimpleLruCahche sl = new SimpleLruCahche(3);
		sl.put("A", 100);
		sl.put("b", 200);
		sl.put("C", 300);
		sl.get("b");
		sl.put("D", 400);
		System.out.println(sl);
	}

}
