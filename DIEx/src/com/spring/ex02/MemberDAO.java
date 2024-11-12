package com.spring.ex02;

public class MemberDAO implements IMemberDAO {

	@Override
	public void selectMembers() {
	
		System.out.println("MemberDAO 객체의 selectMembers() 함수 호출");
	}
}
