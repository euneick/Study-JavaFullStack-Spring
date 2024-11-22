package com.spring.member.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.member.vo.MemberVO;

public interface IMemberDAO {

	public List<MemberVO> selectMembers() throws DataAccessException;
	public MemberVO selectMember(String id) throws DataAccessException;
	public void insertMember(MemberVO member) throws DataAccessException;
	public void updateMember(MemberVO member) throws DataAccessException;
	public void deleteMember(String id) throws DataAccessException;
}
