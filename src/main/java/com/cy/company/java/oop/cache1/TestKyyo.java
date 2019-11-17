package com.cy.company.java.oop.cache1;


import com.cy.company.serializable.User;

public class TestKyyo {
	public static void main(String[] args) {
		User user = new User();
		user.setId(100);
		user.setName("TheXU");
		KryoSerializableCache cache = 
		new KryoSerializableCache(new PertetualCache());
		cache.putObject("A", user);
		
		Object object = cache.getObject("A");
		System.out.println(object);
		
	}
}
