package com.spring.ex03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class LazyTest {

	public static void main(String[] args) {
		
		// 앞선 예제들의 XmlBeanFactory와 비슷한 역할을 하는 컨테이너
		ApplicationContext context = new FileSystemXmlApplicationContext("lazy.xml");
		
		System.out.println("SecondBean 얻기");
		context.getBean("secondBean");
	}

}
