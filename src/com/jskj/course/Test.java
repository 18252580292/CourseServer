package com.jskj.course;

import org.codehaus.jackson.map.ObjectMapper;

import com.jskj.course.domain.User;

public class Test {
	public static void main(String[] args) {
		User user = new User();
		user.setId(3);
		user.setUsername("xiaoming");
		user.setPassword("xiaoming");
		ObjectMapper mapper = new ObjectMapper();
		try {
			String string = mapper.writeValueAsString(user);
			System.out.println(string);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
