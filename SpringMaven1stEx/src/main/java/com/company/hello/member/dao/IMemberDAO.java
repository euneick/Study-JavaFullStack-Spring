package com.company.hello.member.dao;

import java.util.List;

import com.company.hello.member.vo.MemberVO;
import org.springframework.dao.DataAccessException;


public interface IMemberDAO {

	public List<MemberVO> selectMembers() throws DataAccessException;
	public MemberVO selectMember(String id) throws DataAccessException;
	public void insertMember(MemberVO member) throws DataAccessException;
	public void updateMember(MemberVO member) throws DataAccessException;
	public void deleteMember(String id) throws DataAccessException;
}
