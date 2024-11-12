package com.spring.ex01;

public class PersonServiceImpl implements PersonService {

	private String name;
	private int age;

	public PersonServiceImpl() {
	}

	public PersonServiceImpl(String name, int age) {

		this.name = name;
		this.age = age;
	}

	@Override
	public void sayHello() {

		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
