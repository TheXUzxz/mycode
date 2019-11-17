package com.cy.company.java.oop.cls;

import java.lang.reflect.Method;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
//-XX:MetaspaceSize=512m -XX:MaxMetaspaceSize=512m  元数据区参数
public class TestClassObject10   {
	public static void main(String[] args) {
		//如何创建Object子类
		//任意定义类
		//借助字节码增强
		//构建增强对象,//为目标类型创建子类对象
		while(true) {
		Enhancer enhancer = new Enhancer(); 
		//设置父类对象类型
		enhancer.setSuperclass(Object.class); 
		//设置不用缓存
		enhancer.setUseCache(false);
		//设置回调对象
		  enhancer.setCallback(new MethodInterceptor() {
			//调用子类对象(代理对象)
			  @Override
			public Object intercept(
					Object obj,// 增强对象
					Method method, //方法对象
					Object[] args,//目标对象执行时需要
					MethodProxy proxy) throws Throwable {
				System.out.println("intercept");
				Long start= System.currentTimeMillis();
				Object obje = proxy.invokeSuper(obj, args);
				Long end= System.currentTimeMillis();
				System.out.println("create time"+(end-start));
				return obje;
			}
		});  
		
		  //通过字节码技术动态创建子类实例  
		Object obj= enhancer.create(); 
		System.out.println(obj.hashCode());
		
	}
	}
	
	 


	
}
