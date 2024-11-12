package com.spring.ex02;

public class MemberService implements IMemberService {

	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public void getMembersList() {
		memberDAO.selectMembers();
	}
}
