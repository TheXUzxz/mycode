package com.cy.company.java.oop.cls;
//字节码对象
//-XX:+TraceClassLoading类加载分析参数
//字节码对象何时创建?类加载
//字节码对象的类型?(class类型)
//字节码对象的存储在堆区
//字节码对象关联的内容(类的结构信息,存储在方法区)
public class TestClassObject {
		public static void main(String[] args) throws ClassNotFoundException {
			Class<?> c1=	Object.class;
			Class<?> c2 = new Object().getClass();
			Class<?> c3 = Class.forName("java.lang.Object");
			System.out.println(c1==c2);
			System.out.println(c2==c3);
		
			
		}
}
