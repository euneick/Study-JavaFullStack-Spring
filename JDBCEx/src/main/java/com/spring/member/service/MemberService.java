package com.spring.member.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

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
	public MemberVO selectMember(HttpServletRequest request) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertMember(HttpServletRequest request) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMember(HttpServletRequest request) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMember(HttpServletRequest request) throws DataAccessException {
		
		memberDAO.deleteMember(request.getParameter("id"));
	}

}
