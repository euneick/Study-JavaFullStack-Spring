package com.company.hello.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.company.hello.member.vo.MemberVO;

public interface IMemberService {
	
	public List<MemberVO> selectMembers() throws DataAccessException;
	public MemberVO selectMember(String id) throws DataAccessException;
	public void insertMember(MemberVO member) throws DataAccessException;
	public void updateMember(MemberVO member) throws DataAccessException;
	public void deleteMember(String id) throws DataAccessException;
}
