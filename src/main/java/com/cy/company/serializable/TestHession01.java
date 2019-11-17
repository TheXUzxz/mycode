package com.cy.company.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;

public class TestHession01 {
	public static void main(String[] args) throws IOException {
		User user = new User();
		user.setId(100);
		user.setName("TheXu");
		//构建流对象
		OutputStream os=
			new FileOutputStream("b.txt");
		Hessian2Output ho = new Hessian2Output(os);
		//序列化
		ho.writeObject(user);
		ho.close();
		os.close();
		System.out.println("序列化完成");
		//反序列化
		InputStream is = new FileInputStream("b.txt");
		Hessian2Input hi = new Hessian2Input(is);
		Object object = hi.readObject();
		System.out.println(object);
		
		
	}
}
