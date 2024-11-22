package com.spring.member.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.member.dao.MemberDAO;
import com.spring.member.vo.MemberVO;

@Service("memberService")
public class MemberService implements IMemberService {
	
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public List<MemberVO> selectMembers() throws DataAccessException {
		
		return memberDAO.selectMembers();
	}

	@Override
	public MemberVO selectMember(String id) throws DataAccessException {
		
		return memberDAO.selectMember(id);
	}

	@Override
	public void insertMember(MemberVO member) throws DataAccessException {
		
		memberDAO.insertMember(member);
	}

	@Override
	public void updateMember(MemberVO member) throws DataAccessException {

		memberDAO.updateMember(member);
	}

	@Override
	public void deleteMember(String id) throws DataAccessException {
		
		memberDAO.deleteMember(id);
	}

}
