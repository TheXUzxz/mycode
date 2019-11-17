package com.cy.company.java.oop.cls;
//测试类的被动加载
class ClassE{
	static int a =100;
	static {System.out.println("ClassE.static");}
}
class ClassF extends ClassE{
	static int b=200;
	static {
		System.out.println("ClassF.static");
	}
}
public class TestClassObject08 {	
		public static void main(String[] args) {
			//ClassE为主动加载
			//ClassF 为被动加载(不会执行static)
		System.out.println(ClassF.b);
	}

}
