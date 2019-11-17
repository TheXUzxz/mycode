package com.cy.company.java.oop.instance;
//ThreadLocal应用:它提供了一种线程绑定机制
class Looper{
		private Looper() {
			System.out.println("Looper() ");
		}
	
		private static Looper instance;
		private  static ThreadLocal<Looper> pool 
		=  new ThreadLocal<Looper>();
//		new ThreadLocal<Looper>() {
//		protected Looper initialValue() {
//		 instance = new Looper();
//			return instance;
//		};
//	};
	public static Looper getInstance() {
		if (instance==null) {
			instance = new Looper();
			pool.set(instance);
		}
		return instance;
	}
}
public class TestObjectInstance06 {
	public static void main(String[] args) {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				Looper instance = Looper.getInstance();
				Looper instance2 = Looper.getInstance();
				System.out.println(instance==instance2);
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				Looper instance = Looper.getInstance();
				Looper instance2 = Looper.getInstance();
				System.out.println(instance==instance2);
			}
		};
		t1.start();
		t2.start();
	}

}
