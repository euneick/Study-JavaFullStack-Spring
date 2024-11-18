package com.jsp.ex01;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {
	/*
	 * 참고. SqlSession클래스
	 * 		- mapper파일(member.xml)에 작성된 SQL문을 실행하고 트랜잭션을 관리하는 클래스 입니다.
	 * 		- 메소드 종류
	 * 			1. selectOne메소드 T selectOne()
	 * 				- 조회한 하나의 객체를 리턴하는 메소드
	 * 
	 * 			2. selectList메소드 List<E> selectList()
	 * 				- 조회한 여러개의 객체가 담긴 리스트를 리턴하는 메소드
	 * 
	 * 			3. selectMap메소드 Map<E> selectMap()
	 * 				- 조회한 여러객체들의 Map에 key,value형태로 담긴 Map을 리턴하는 메소드
	 */
	private static SqlSessionFactory sqlMapper = null;

	public static SqlSessionFactory getInstance() {

		if (sqlMapper == null) {
			try {
				String resource = "mybatis/SqlMapConfig.xml";
				Reader reader = Resources.getResourceAsReader(resource);

				sqlMapper = new SqlSessionFactoryBuilder().build(reader);

			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;
	}

	public List<MemberVO> selectAllMemberList() {

		sqlMapper = getInstance();

		SqlSession session = sqlMapper.openSession();

		List<MemberVO> memlist = session.selectList("mapper.member.selectAllMemberList");

		return memlist;
	}
}
