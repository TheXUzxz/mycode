package com.cy.company.java.oop.instance;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 
 * */
class A{
	public A() {
		System.out.println("A{}");
	}
}
class B{
	public B() {
		System.out.println("B{}");
	}
}
class ObjectPool{
	private static Map<String, Object> map = new HashMap<String, Object>();
	static {
		map.put("key1", new A());
		map.put("key2", new B());
	}
	public static Object getObject(String key) {
		return map.get(key);
	}
}
 
public class TestObjectInstance05 {
		public static void main(String[] args) {
			 Object o1 = ObjectPool.getObject("key1");
			 Object o2 = ObjectPool.getObject("key1");
			System.out.println(o1==o2);
		}
}
