package com.cy.company.java.oop.cache1;

import com.cy.company.serializable.KryoUitl;
import org.apache.ibatis.cache.impl.PerpetualCache;


public class KryoSerializableCache implements Cache{
		private Cache cache;
		public KryoSerializableCache(Cache cache) {
			this.cache=cache;
		}
	@Override
	public void putObject(Object key, Object value) {
		try {
			byte[] array = KryoUitl.serializable(value);
			cache.putObject(key, array);
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
	}

	@Override
	public Object getObject(Object key) {
		
		byte[] array = (byte[]) cache.getObject(key);
	
		
			return KryoUitl.deserializable(array);
		
		
	}

	@Override
	public Object removeObject(Object key) {
		// TODO Auto-generated method stub
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
	
}
