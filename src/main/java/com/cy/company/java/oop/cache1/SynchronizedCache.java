package com.cy.company.java.oop.cache1;

public class SynchronizedCache implements Cache {

	private Cache cache;
	public SynchronizedCache(Cache cache) {
		this.cache=cache;
	}
	@Override
	public synchronized void putObject(Object key, Object value) {
         cache.putObject(key, value);
	}

	@Override
	public synchronized Object getObject(Object key) {
		// TODO Auto-generated method stub
		return cache.getObject(key);
	}

	@Override
	public synchronized Object removeObject(Object key) {
		// TODO Auto-generated method stub
		return cache.removeObject(key);
	}

	@Override
	public synchronized void clear() {
		cache.clear();
	}

	@Override
	public synchronized int size() {
		return cache.size();
	}
	public static void main(String[] args) {
		SynchronizedCache logCache=
	    new SynchronizedCache(new LogCache(new FifoCache(new PertetualCache(),3)));
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
