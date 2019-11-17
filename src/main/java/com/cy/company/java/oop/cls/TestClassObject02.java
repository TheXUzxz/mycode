package com.cy.company.java.oop.cls;

import com.cy.company.java.oop.cls.Outer.Inner02;
//外部类加载时会加载内部类吗:不会
class Outer{
	class Inner01{}
	static class Inner02{}
}
public class TestClassObject02 {
			public static void main(String[] args) throws Exception {
//				Class<?> o1= Outer.class;//此类会被加载,Inner01不会被加载
				Class<?> c2 =Outer.Inner02.class;
				Class<?> c3 = Class.forName("com.company.java.oop.cls.Outer$Inner02");
			System.out.println(c2==c3);
			new Outer.Inner02();//只加载Inner02
			
			
			
			}
}
