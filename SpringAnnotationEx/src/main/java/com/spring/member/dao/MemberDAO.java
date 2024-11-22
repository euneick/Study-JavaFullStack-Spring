package com.spring.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.member.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAO implements IMemberDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<MemberVO> selectMembers() throws DataAccessException {

		return sqlSession.selectList("mapper.member.selectAllMemberList");
	}

	@Override
	public MemberVO selectMember(String id) throws DataAccessException {

		return (MemberVO) sqlSession.selectOne("mapper.member.selectMemberById", id);
	}

	@Override
	public void insertMember(MemberVO member) throws DataAccessException {

		sqlSession.insert("mapper.member.insertMember", member);
	}

	@Override
	public void updateMember(MemberVO member) throws DataAccessException {

		sqlSession.update("mapper.member.updateMember", member);
	}

	@Override
	public void deleteMember(String id) throws DataAccessException {

		sqlSession.delete("mapper.member.deleteMember", id);
	}

}
