package com.cy.company.java.oop.instance;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

//1)强引用(通过对象类型的变量直接引用,例如Object o1=new Object())
//2)弱引用(WeakReference<T>) 只要有 GC,弱引用引用的对象就会被回收。
//3)软引用(SoftReference<T>)一般是FULL GC,软引用引用的对象会被回收。
//4)虚引用(PhantomReference<T>) 当对象被回收时,可以得到通知。
class ClassB{
	public void doMethod() {
		System.out.println("doMethod() ");
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("void finalize()");
	}
}
public class TestObjectInstance03 {
	public static void main(String[] args) {
		//强引用
//		ClassB c1= new ClassB ();
		//2弱引用
//		WeakReference<ClassB> c2 = 
//	new WeakReference<ClassB>( new ClassB());
		//3.软引用
		SoftReference<ClassB> c3 = new SoftReference<ClassB>(new ClassB());
		List<byte[]> list=new ArrayList<byte[]>();
		for (int i = 0; i < 10000; i++) {
			list.add(new byte[1024]);
			if (c3.get()!=null) {
				c3.get().doMethod();
			}
		}
		
		
		
	}
}
