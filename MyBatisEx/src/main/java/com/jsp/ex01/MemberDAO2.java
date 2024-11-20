package com.jsp.ex01;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.mappers.IMemberMapper;
import mybatis.mappers.MyBatisConfig;

public class MemberDAO2 {

	private static SqlSessionFactory sqlMapper;
	
	public MemberDAO2() {
		sqlMapper = MyBatisConfig.getSqlMapper();
	}
	
	public List<MemberVO> selectAllMemberList() {

		List<MemberVO> membersList = null;
		
		SqlSession session = null; 

		try {
			session = sqlMapper.openSession();

			IMemberMapper mapper = session.getMapper(IMemberMapper.class);	// 동적 Proxy 객체 생성

			membersList = mapper.selectMembersList();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) session.close();
		}
		
		return membersList;
	}

	public MemberVO selectMemberById(String id) {

		MemberVO member = null;
		
		SqlSession session = null; 

		try {
			session = sqlMapper.openSession();

			IMemberMapper mapper = session.getMapper(IMemberMapper.class);	// 동적 Proxy 객체 생성

			member = mapper.selectMember(id);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) session.close();
		}
		
		return member;
	}
}
