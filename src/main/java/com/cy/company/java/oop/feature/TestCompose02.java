package com.cy.company.java.oop.feature;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class SimpleFifoCache{
	private int maxCap;
	public SimpleFifoCache(int maxCap) {
		this.maxCap=maxCap;
		
			
		
	}
	private Map<Object, Object> cacheMap 
	= new HashMap<Object, Object>();
	private Deque<Object> keyOrders
	=new LinkedList<Object>();
	public Object getObject(Object key) {
		return cacheMap.get(key);
	}
	public void putObject(Object key,Object value) {
		
			//记录key对象(入队操作,放在队尾)
			keyOrders.addLast(key);
			//判断容器中是否满了,满了则移除容器中最早放入的元素
			
			if (keyOrders.size()>maxCap) {
				 //队列出队操作
				  Object oldKey =
						 
			keyOrders.removeFirst();
				  //基于key移除cache中的对象
				  cacheMap.remove(oldKey);
				  
			}
			cacheMap.put(key, value);
		
	}
	@Override
	public String toString() {
		
		return cacheMap.toString();
	}
}
public class TestCompose02 {
	public static void main(String[] args) {
		SimpleFifoCache sf = new SimpleFifoCache(3);
		sf.putObject("A", 100);
		sf.putObject("B", 300);
		sf.putObject("C", 400);
		sf.putObject("d", 200);
		sf.putObject("e", 500);
		System.out.println(sf.toString());
		
	}


}
