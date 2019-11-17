package com.cy.company.java.oop.cls;
/**
 * 显示加载
 * */
class A{
	//类加载时可以执行静态代码块
	static {
		System.out.println("class A static{}");
	}
}
public class TestClassObject04 {
	public static void main(String[] args) throws ClassNotFoundException {
		
		ClassLoader loader = ClassLoader.getSystemClassLoader();
		//此方式加载类不会执行静态代码块
//		loader.loadClass("com.company.java.oop.cls.A");
		//会执行静态代码块
//		Class.forName("com.company.java.oop.cls.A");
		Class.forName("com.company.java.oop.cls.A", 
				false, loader);
			}
	
}
