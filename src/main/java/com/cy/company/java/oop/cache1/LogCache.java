package com.cy.company.java.oop.cache1;

import org.apache.juli.logging.Log;

/**
   *   通过此Cache记录命中率
 * 
 *
 */
public class LogCache implements Cache{
	/**记录请求次数*/
	private int requests;
	/**记录命中次数*/
	private int hits;
	private Cache cache;
	public LogCache(Cache cache) {
		this.cache=cache;
	}
	@Override
	public void putObject(Object key, Object value) {
	    cache.putObject(key, value);
	}
	@Override
	public Object getObject(Object key) {
		requests++;
		Object obj=cache.getObject(key);
		if(obj!=null) {
			hits++;
		}
		System.out.println("hits:"+hits*1.0/requests);
		return obj;
	}
	@Override
	public Object removeObject(Object key) {
		return cache.removeObject(key);
	}
	@Override
	public void clear() {
		cache.clear();
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
		LogCache logCache=
	    new LogCache(new PertetualCache());
		logCache.putObject("A", 100);
		logCache.putObject("B", 200);
		logCache.putObject("C", 300);
		logCache.putObject("D", 300);
		logCache.getObject("D");
		logCache.getObject("A");
		logCache.getObject("B");
		System.out.println(logCache);
	}

}





