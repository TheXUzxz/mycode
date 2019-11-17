package com.cy.company.java.oop.cls;

/* 
 * 分析类加载器
 * 类的加载由类加
 * */


public class TestClassObject03 {
			public static void main(String[] args)
					throws Exception {
				//1.AppClassLoader
				ClassLoader loader01 
				= ClassLoader.getSystemClassLoader();
				System.out.println(loader01.getClass());
				//2ExtClassLoader
				ClassLoader loader02 
				= loader01.getParent();
				System.out.println(loader02.getClass());
				//3BootstrapClassLoader
				ClassLoader loader03 = loader02.getParent();
				System.out.println(loader03);
				
			}
}
