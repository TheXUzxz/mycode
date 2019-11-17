package com.cy.company.java.oop.cache1;
import java.util.HashMap;
/**
  *  缓存对象,其特点
 * 1)存储结构:散列存储
 * 2)淘汰算法:没有
 */
public final class PertetualCache implements Cache {
    //has a 
	private HashMap<Object,Object> cache=new HashMap<Object, Object>();
	@Override
	public void putObject(Object key, Object value) {
	     cache.put(key, value);
	}

	@Override
	public Object getObject(Object key) {
		return cache.get(key);
	}

	@Override
	public Object removeObject(Object key) {
		return cache.remove(key);
	}
	@Override
	public int size() {
		return cache.size();
	}
	@Override
	public void clear() {
		cache.clear();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return cache.toString();
	}

}
