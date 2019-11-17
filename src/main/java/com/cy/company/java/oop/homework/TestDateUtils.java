package com.cy.company.java.oop.homework;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 分析如下代码,回答如下问题:
 * 1)类的设计是否存在问题?存在什么问题?
 * 2)假如存在问题,如何解决这个问题?
 */
class DateUtils{
	private static ThreadLocal<SimpleDateFormat>  
	tl=new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy/MM/dd");
		}
		
	};
	
	
	public static Date parse(String source)
	throws Exception{
		return tl.get().parse(source);
	}
	public static String format(Date date) {
		return tl.get().format(date);
	}
}
public class TestDateUtils {
    public static void main(String[] args) {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				try {
					Date date = DateUtils.parse("1996/10/11");
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
//		Thread t2 = new Thread() {
//			@Override
//			public void run() {
//				try {
//					Date date = DateUtils.parse("1998/10/11");
//					System.out.println(date);
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		};
		t1.start();
//		t2.start();
	}
}
