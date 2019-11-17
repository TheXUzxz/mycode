package com.cy.company.java.oop.instance;
/**
 * 案例分析:对象的创建时的内存分配?
 * 1)堆
 * 2)栈(未逃逸的小对象)
 * 如何检测对象分配在哪里了?JVM 参数配置
 * 1)-XX:+PrintGC 输出GC基本信息
 * JDK8中逃逸分析默认开启了吗?开启了
 * -XX:+DoEscapeAnalysis
 * JDK中最大堆,最小堆配置?
 * 1)最大堆-Xmx
 * 2)最小堆-Xms
 * JVM参数测试:(在堆内存有限的情况下测试JVM逃逸分析)
 * 1)-Xmx5m -Xms5m -XX:-DoEscapeAnalysis -XX:+PrintGC
 * 2)-Xmx5m -Xms5m -XX:+DoEscapeAnalysis -XX:+PrintGC
 * 6.如何查看当前JDK中逃逸分析默认状态
 *-XX:PrintFlagsInitial
 */
public class TestObjectInstance01 {
	public static void main(String[] args) {
		Long start= System.currentTimeMillis();
		for (int i = 0; i < 100000000; i++) {
			alloc() ;
		}
		Long end= System.currentTimeMillis();
		System.out.println("create time:"+(end-start));
	}
	//jdk6以后 HotSpot虚拟机支持运行时逃逸分析
	//方法内创建的对象没有被外界引用称之为未逃逸对象
	//现阶段的JDK中未逃逸的小对象有可能直接分配在栈上
	
	static void alloc() {
		//创建只能存储一个字节的对象数组
		byte [] array = new byte[1];
		array[0]=10;
	}
}
