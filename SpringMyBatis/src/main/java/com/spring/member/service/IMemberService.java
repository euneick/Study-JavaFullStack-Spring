package com.spring.member.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataAccessException;

import com.spring.member.vo.MemberVO;

public interface IMemberService {
	
	public List<MemberVO> selectMembers() throws DataAccessException;
	public MemberVO selectMember(HttpServletRequest request) throws DataAccessException;
	public void insertMember(HttpServletRequest request) throws DataAccessException;
	public void updateMember(HttpServletRequest request) throws DataAccessException;
	public void deleteMember(HttpServletRequest request) throws DataAccessException;
}
