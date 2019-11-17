package com.cy.company.serializable;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Message implements Serializable{

	private static final long serialVersionUID = -1049841843910180366L;
	private int id;
	private String content;
	
	public Message() {
		super();
	}

	public Message(int id, String content) {
		super();
		this.id = id;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", content=" + content + "]";
	}
	
	
}
public class TestSerializablle {
	public static void main(String[] args) throws Exception, IOException {
		Message msg = new Message(1, "hello cgb1907");
		ObjectOutputStream out =new 
				ObjectOutputStream(
			new FileOutputStream("aa.dat"));
		out.writeObject(msg);
		out.flush();
		out.close();
		System.out.println("序列化完成");
		ObjectInputStream oi = 
		new ObjectInputStream(
		new FileInputStream("aa.dat"));
		Message msg1 =  (Message) oi.readObject();
		oi.close();
		System.out.println(msg1);
		System.out.println(msg==msg1);
		System.out.println("反序列化完成");
	}

}
