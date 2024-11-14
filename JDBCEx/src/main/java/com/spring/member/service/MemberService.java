package com.spring.member.service;

import java.util.ArrayList;

import org.springframework.dao.DataAccessException;

import com.spring.member.dao.MemberDAO;
import com.spring.member.vo.MemberVO;

public class MemberService implements IMemberService {
	
	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO) { this.memberDAO = memberDAO; }

	@Override
	public ArrayList<MemberVO> selectMembers() throws DataAccessException {
		
		return memberDAO.selectMembers();
	}

	@Override
	public MemberVO selectMember(String id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertMember(MemberVO member) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMember(MemberVO member) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMember(String id) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

}
