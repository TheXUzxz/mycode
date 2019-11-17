package com.cy.company.java.oop.cls;
class ClassCC{
	static {
		
		System.out.println("static{}");
	}
	static ClassCC instance = new ClassCC();
		int a ;
	{	
		a=100;
		System.out.println("{}");
	}
	public ClassCC(){
		a=200;
		System.out.println("ClassCC");
		
	}
}
public class TestClassObject09 {
	public static void main(String[] args) {
		ClassCC instance = ClassCC.instance;
	
	}
}
