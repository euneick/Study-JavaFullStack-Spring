package com.spring.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.member.vo.MemberVO;

public class MemberDAO implements IMemberDAO {

	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(DataSource dataSource) { jdbcTemplate = new JdbcTemplate(dataSource); }

	@Override
	public ArrayList<MemberVO> selectMembers() throws DataAccessException {

		String sql = "SELECT * FROM t_member ORDER BY joinDate DESC";

		ArrayList<MemberVO> membersList = null;

		membersList = (ArrayList<MemberVO>) jdbcTemplate.query(sql, new RowMapper<MemberVO>() {

			@Override
			public MemberVO mapRow(ResultSet resultSet, int rowNum) throws SQLException {

				MemberVO member = new MemberVO();

				member.setId(resultSet.getString("id"));
				member.setPass(resultSet.getString("pwd"));
				member.setName(resultSet.getString("name"));
				member.setEmail(resultSet.getString("email"));
				member.setJoinDate(resultSet.getDate("joinDate"));

				return member;
			}

		});

		return membersList.isEmpty() ? null : membersList;
	}

	@Override
	public MemberVO selectMember(String id) throws DataAccessException {

		String sql = "SELECT * FROM T_MEMBER WHERE id=?";

		MemberVO member = jdbcTemplate.queryForObject(sql, new RowMapper<MemberVO>() {

			@Override
			public MemberVO mapRow(ResultSet resultSet, int rowNum) throws SQLException {

				MemberVO member = new MemberVO();
				
				member.setId(resultSet.getString("id"));
				member.setPass(resultSet.getString("pwd"));
				member.setName(resultSet.getString("name"));
				member.setEmail(resultSet.getString("email"));
				member.setJoinDate(resultSet.getDate("joinDate"));

				return member;
			}
		}, id);

		return member;
	}

	@Override
	public void insertMember(MemberVO member) throws DataAccessException {

		String sql = "INSERT INTO T_MEMBER (ID, PWD, NAME, EMAIL)" + "VALUES(?,?,?,?)";

		jdbcTemplate.update(sql, member.getId(), member.getPass(), member.getName(), member.getEmail());
	}

	@Override
	public void updateMember(MemberVO member) throws DataAccessException {

		this.jdbcTemplate.update("update t_member set pwd=?, name=?, email=? where id=?",
				member.getPass(), member.getName(), member.getEmail(), member.getId());
	}

	@Override
	public void deleteMember(String id) throws DataAccessException {

		String sql = "DELETE FROM T_MEMBER WHERE id=?";

		jdbcTemplate.update(sql, id);
	}

}
