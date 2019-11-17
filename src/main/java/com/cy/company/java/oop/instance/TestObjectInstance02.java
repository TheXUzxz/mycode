package com.cy.company.java.oop.instance;
class ClassA{
	/** 对象在回收之前执行该方法*/
	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize()");
	}
}
//-Xmx5m -Xms5m -XX:+PrintGCDetails
public class TestObjectInstance02 {
	public static void main(String[] args) {
		//new ClassA();
		ClassA a = new ClassA();
		//手动启动GC(告诉JVM有时间回收一个内存)
		a=null;
//		System.gc();
		byte array[] = new byte[1024*1024]; 
		byte array2[] = new byte[1024*1024];
		byte array3[] = new byte[1024*1024];
		byte array4[] = new byte[1024*1024];
		byte array5[] = new byte[1024*1024];
	}
}
