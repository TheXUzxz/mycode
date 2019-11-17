package com.cy.company.java.generic;

import java.util.Collection;
import java.util.List;

class ObjectFactory{
	public <T>T newInstance(Class<T> cls) throws Exception{
		return cls.newInstance();
	}
	public <T>boolean isConnections(Class<T> cls){
		return Collection.class.isAssignableFrom(cls);
	}
} 
public class TestGenneric02 {
			public static void main(String[] args) throws Exception {
				ObjectFactory of =new ObjectFactory();
				 TestGenneric02 list = 
			of.newInstance(TestGenneric02.class);
				System.out.println(list);
			}
}
