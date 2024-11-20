package com.spring.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.member.vo.MemberVO;

public class MemberDAO implements IMemberDAO {

	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) { this.sqlSession = sqlSession; }

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
