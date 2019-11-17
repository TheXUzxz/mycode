package com.cy.company.java.oop.cache1;

import java.util.Deque;
import java.util.LinkedList;

public class FifoCache implements Cache{
	private Deque<Object> keyOrders=new LinkedList<Object>();
	private int maxCap=1024;
	private Cache cache;
	public FifoCache(Cache cache,int maxCap) {
		this.cache=cache;
		this.maxCap=maxCap;
	}
	@Override
	public void putObject(Object key, Object value) {
	    //1.存储key
		keyOrders.addLast(key);
		//2.满了移除对象
		if(size()==maxCap) {
			Object oldKey=keyOrders.removeFirst();
			cache.removeObject(oldKey);
		}
		//3.存储key/value
		cache.putObject(key, value);
	}
	@Override
	public Object getObject(Object key) {
		return cache.getObject(key);
	}
	@Override
	public Object removeObject(Object key) {
		return cache.removeObject(key);
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
	public static void main(String[] args) {
		LogCache logCache=
	    new LogCache(new FifoCache(new PertetualCache(),3));
		logCache.putObject("A", 100);
		logCache.putObject("B", 200);
		logCache.putObject("C", 300);
		logCache.putObject("D", 400);
		logCache.getObject("D");
		logCache.getObject("A");
		logCache.getObject("B");
		System.out.println(logCache);
	}
	

}
