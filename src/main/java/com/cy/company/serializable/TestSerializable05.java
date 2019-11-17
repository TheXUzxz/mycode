package com.cy.company.serializable;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestSerializable05 {
	public static void main(String[] args) throws Exception {
		User user = new User();
		user.setId(100);
		user.setName("陈子枢");
		ObjectMapper om = new ObjectMapper();
		String s = om.writeValueAsString(user);
		System.out.println(s);
		User user1 = om.readValue(s, User.class);
		System.out.println(user1);
		
	}

}
