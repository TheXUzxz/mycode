package com.cy.company.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public class TestKryo01 {
	public static void main(String[] args) throws Exception {
		//使用kryo框架进行序列化
		Kryo  kryo = new Kryo();
		kryo.register(User.class);
		User u = new User();
		u.setId(1);
		u.setName("TheXu");
		Output output = new Output(new FileOutputStream("aa.txt"));
		kryo.writeObject(output, u);
		output.close();
		//使用kryo框架进行反序列化
		Input input = new Input(new FileInputStream("aa.txt"));
		User user = kryo.readObject(input, User.class);
		System.out.println(user);
		
	}

}
