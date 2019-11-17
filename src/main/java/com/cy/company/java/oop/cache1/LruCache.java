package com.cy.company.java.oop.cache1;

import java.util.LinkedHashMap;
import java.util.Map;



public class LruCache implements Cache {

	private Cache cache;
	private Map<Object, Object> keyMap;
	//记录老的key
	private Object oldKey;
	public  LruCache(Cache cache,int maxCap) {
		this.cache=cache;
		//记录访问顺序
		keyMap=new LinkedHashMap<Object, Object>
		(maxCap, 0.75f, true){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected boolean 
			//移除最近最少访问
			removeEldestEntry(Map.Entry<Object, Object> eldest) {
				boolean flag=size()>maxCap;
				if (flag) {
				 oldKey = eldest.getKey();
				}
				return	flag;
			}
		};
	}
	private void cycleKeyList(Object key) {
		keyMap.put(key, key);//对于value而言任意
		if (oldKey!=null) {
			//从cache里移除元素
			cache.removeObject(oldKey);
			oldKey=null;
		}
	}
	@Override
	public void putObject(Object key, Object value) {
		cache.putObject(key, value);
		//记录key访问顺序
		cycleKeyList(key);

	}

	@Override
	public Object getObject(Object key) {
		//记录key访问顺序
		keyMap.get(key);
		return cache.getObject(key);
	}

	@Override
	public Object removeObject(Object key) {
		keyMap.remove(key);
		return cache.removeObject(key);
	}

	@Override
	public void clear() {
		cache.clear();
		keyMap.clear();
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return cache.size();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return cache.toString();
	}
	public static void main(String[] args) {
			LogCache logCache = new LogCache(new LruCache(new PertetualCache(), 3));
		logCache.putObject("A", 100);
		logCache.putObject("B", 200);
		logCache.putObject("C", 300);
		logCache.getObject("A");
		logCache.putObject("D", 400);
		logCache.putObject("E", 500);
		
		System.out.println(logCache);
	
}
	
}
