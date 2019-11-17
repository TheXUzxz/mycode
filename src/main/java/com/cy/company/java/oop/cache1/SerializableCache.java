package com.cy.company.java.oop.cache1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableCache implements Cache {
	private Cache cache;
	
	public SerializableCache(Cache cache) {
		
		this.cache = cache;
	}
	//序列化方法
	private byte[] serializable(Object object) throws Exception {
		//构建字节数组输出流
		ByteArrayOutputStream  bao = new ByteArrayOutputStream();
		//构建对象输出流
		ObjectOutputStream  oos = new ObjectOutputStream(bao);
		oos.writeObject(object);
		byte[] array = bao.toByteArray();
		oos.close();
		
		return array;
		
		
	}
	//反序列化
	private Object deSerializable(byte[] array)throws Exception{
		//构建字节数组输入流
		ByteArrayInputStream bas = new ByteArrayInputStream(array);
		//构建对象输入流
		ObjectInputStream  ois = new ObjectInputStream(bas);
		//反序列化
		Object object = ois.readObject();
		//释放资源
		ois.close();
		return object;
	}
	@Override
	public void putObject(Object key, Object value) {
		
		try {
			//1将对象序列化(字节数组)
			byte[] array = serializable(value);
			//2将对象存储到cache
			cache.putObject(key, array);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	

	@Override
	public Object getObject(Object key) {
		
		//从cache获取对象(字节数组)
		byte[] array =(byte[]) cache.getObject(key);
		try {
		
			
			//将字节数组中的内容反序列化
		Object  object= deSerializable(array);
		return object;
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
		
	}

	@Override
	public Object removeObject(Object key) {
		// TODO Auto-generated method stub
		return cache.removeObject(key);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		cache.clear();
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return cache.size();
	}

}
