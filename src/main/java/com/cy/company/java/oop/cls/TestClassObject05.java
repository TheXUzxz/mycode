package com.cy.company.java.oop.cls;
/*** 
 * 何时会触发类加载?
 * 访问使用static final修饰的八种基本类型以及String不会触发类加载
 * 访问只有static修饰的任意属性时都会触发类加载
 * 访问类的静态方法
 * 构建对象
 * //-XX:+TraceClassLoading类加载分析参数
 * */
class ClassB{

	static final int a=100;
	static int [] array=new  int[1024];
	static void doMethod() {
		System.out.println("ClassB.doMethod()");
	}
}
public class TestClassObject05 {
		public static void main(String[] args) {
//			ClassB c1;
//			int[] array = ClassB.array;
//			ClassB.doMethod();
//			System.out.println(ClassB.a);
		}
}
