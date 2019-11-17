package com.cy.company.serializable;

import com.cy.company.java.oop.cache1.PertetualCache;
import com.cy.company.java.oop.cache1.SerializableCache;

import java.io.Serializable;


class Problem implements Serializable{
	private static final long serialVersionUID = 2825969096191535643L;
	private Integer id ;
	private String title;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Problem [id=" + id + ", title=" + title + "]";
	}
	
	
}

public class TestSerializablle02 {
	public static void main(String[] args) {
		Problem p = new Problem();
		p.setId(100);
		p.setTitle("hello java");
		SerializableCache ser =
	new SerializableCache(new PertetualCache());
		ser.putObject("p",p);
		Object object = ser.getObject("p");
		System.out.println(object);
		
	}

}
