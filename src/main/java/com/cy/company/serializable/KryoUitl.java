package com.cy.company.serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public final class KryoUitl {
	private  KryoUitl() {}
	private static ThreadLocal<Kryo> tl =new ThreadLocal<Kryo>() {
		protected Kryo initialValue() {
			Kryo kryo = new Kryo();
			kryo.setRegistrationRequired(false);
			 
			return kryo;
		};
	};
	
	public static byte[] serializable(Object object) throws Exception {
		
		//构建字节数组输出流
		ByteArrayOutputStream bas = new ByteArrayOutputStream();
		//构建输出流
		Output output = new Output(bas);
		//从当前线程获取kryo对象
		Kryo kryo = tl.get();
		
		//序列化
		kryo.writeClassAndObject(output, object);
		//释放资源
		output.close();
		bas.close();
		return bas.toByteArray();
		
	}
	//反序列化
	public static Object deserializable(byte[] array) {
			//获取字节数组输入流
			ByteArrayInputStream bai = new ByteArrayInputStream(array);
			//构建输入流
			Input input = new Input(bai);
			//从当前线程获取kryo对象
			Kryo kryo = tl.get();
			//反序列化
			Object object = kryo.readClassAndObject(input);
			
			
		return object;
		
	}

}
