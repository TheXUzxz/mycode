package com.cy.company.java.oop.homework;
/**
 * 如何对Singleton类进行设计,才能保证:
 * 1)此类对外只有一个实例
 * 2)此类对象可以在高并发环境下频繁使用.
 * 3)此类的对象在本类加载时不会创建实例?
 */

class Singleton{
	private Singleton() {
		System.out.println("Singleton()");
	}
	static class  classS{
		private static final Singleton instance = new Singleton();
	}
	public static Singleton getInstance() {
		return classS.instance;
	}
}
public class TestSingleton {
	public static void main(String[] args) {
		Thread t1 =new Thread() {
			@Override
			public void run() {
				Singleton instance = Singleton.getInstance();
				Singleton instance2 = Singleton.getInstance();
				System.out.println(instance==instance2);
			}
			
		};
		t1.start();
	}

}
