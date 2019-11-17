package com.cy.company.java.oop.cls;
/**
 * 考察类变量初始化问题
 * */

import java.util.HashMap;
import java.util.Map;

class ClassD{
	static  Map<String, Object> map =new HashMap<String, Object>();
	static ClassD instance = new ClassD();
	public ClassD() {
		map.put("A", 100);
		map.put("B", 100);
	}
	
}
public class TestClassObject07 {
		public static void main(String[] args) {
			System.out.println(ClassD.map);
		}
}
