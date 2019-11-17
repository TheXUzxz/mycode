package com.cy.company.java.oop.cls;

import java.util.Arrays;

class ClassC{
	static class Inner{
	static int [] array = new int[1024];
	}
	static void doMethod01() {
		System.out.println("doMethod01()");
	}
	static void doMethod02() {
		System.out.println(Arrays.toString(Inner.array));
	}
}
public class TestClassObject06 {

}
