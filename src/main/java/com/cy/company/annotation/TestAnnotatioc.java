package com.cy.company.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface select{
	String value();
}
interface GoodsDao{
	@select("select * from goods where id =#{id}")
	public void findByid(Integer id);
}
public class TestAnnotatioc {
	public static void main(String[] args) throws Exception {
	Class<?> cls=	GoodsDao.class;
	Method me = cls.getDeclaredMethod("findByid", Integer.class);
	select s = me.getAnnotation(select.class);
	String value = s.value();
	System.out.println(value);
	
	}

}
