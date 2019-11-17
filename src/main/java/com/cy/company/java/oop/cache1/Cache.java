package com.cy.company.java.oop.cache1;
/**
  *  定义缓存标准的一个对象
 * @author Administrator
 */
public interface Cache {
    /**存储对象*/
	void putObject(Object key, Object value);
	/**基于key取对象*/
	Object getObject(Object key);
	/**基于key移除对象*/
	Object removeObject(Object key);
	/**清缓存*/
	void clear();
	int size();
	//.......
}
