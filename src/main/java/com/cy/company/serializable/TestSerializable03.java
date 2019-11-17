package com.cy.company.serializable;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

class Respey implements Serializable{
	private Integer id;
	private String 	rest;
	private void writeObject(ObjectOutputStream out) throws IOException {
		//获取加密对象
		Encoder encoder = Base64.getEncoder();
		//对内容进行加密
		byte[] result = encoder.encode(rest.getBytes());
			rest=new String(result);
			out.defaultWriteObject();
	}
	private void readObject(java.io.ObjectInputStream is) throws Exception {
		is.defaultReadObject();
		Decoder der = Base64.getDecoder();
		byte[] array
		= der.decode(rest);
		rest=new String(array);
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRest() {
		return rest;
	}
	public void setRest(String rest) {
		this.rest = rest;
	}
	
}
public class TestSerializable03 {
	static void doServer(){}
	static void doClient() {}
	public static void main(String[] args) {
		
	}

}
