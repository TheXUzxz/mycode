package com.cy.company.java.oop.instance;
//单例设计:单线程模式
class Singleton01{
	private Singleton01() {
		System.out.println("singleton01()");
	}
	private static Singleton01 instance ;
	public static Singleton01 getInstance() {
		if (instance ==null) {
			instance=new Singleton01();
		}
		return instance;
	
	}
	
}
//单例设计:多线程
class Singleton02{
	private Singleton02() {
		System.out.println("singleton02()");
	}
	//volatile关键在的作用?
		//1)保证多线程之间变量的可见性(一个线程修改了此变量的值,其它的立刻可见)
		//2)禁止指令重排序(JVM内部对指令执行有优化)
		//3)不能保证原子性
	private static volatile Singleton02 instance ;
	public static  Singleton02 getInstance() {
		if (instance ==null) {
			
		synchronized (Singleton02.class) {
		if (instance ==null) {
			instance=new Singleton02();
			}
				}
		}
		return instance;
	}
	
}
//单例3:静态内部类
class Singleton03{
	 byte []array= new byte[1024*1024*1024];
	 public static void show() {
		 System.out.println("show()");
	 }
	 private Singleton03() {
		System.out.println("Singleton03()");
	}
	static class Singleton{
		private static final Singleton03 
		instance= new Singleton03();
	}
	public static Singleton03 getInstance() {
		return Singleton.instance;
	}
}
//单例4:ThreadLocal
class Singleton04{
		private Singleton04() {
			System.out.println("Singleton04()");
		}
		private static Singleton04 instance;
		private	static ThreadLocal<Singleton04> tl=
				new ThreadLocal<Singleton04>() {
			protected Singleton04 initialValue() {
				instance = new Singleton04();
				return instance;
			};
		};
	public static Singleton04 getInstance() {
		if (instance==null) {
			instance =tl.get();
		}
		return instance;
	}
	
}
public class TestObjectInstance04 {
	  public static void main(String[] args) {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				Singleton03.show();
			
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				Singleton03.show();
				
			}
		};
		t1.start();
		t2.start();
	}
}
