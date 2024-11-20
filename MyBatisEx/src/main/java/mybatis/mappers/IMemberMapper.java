package mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.jsp.ex01.MemberVO;

public interface IMemberMapper {

	/*
		@Select 실행 결과는 자동으로 List<MemberVO>로 설정 됨
		@Results
			- SQL 실행 결과 (ResultSet)를 자바 객체의 속성에 설정
	 */
	@Select("select * from t_member order by joinDate desc")
	@Results(id = "memResult", value = {
		@Result(property = "id", column = "id"),
		@Result(property = "pwd", column = "pwd"),
		@Result(property = "name", column = "name"),
		@Result(property = "email", column = "email"),
		@Result(property = "joinDate", column = "joinDate")
	})
	public List<MemberVO> selectMembersList();
	
	@Select("select * from t_member where id=#{id}")
	@ResultMap("memResult")
	public MemberVO selectMember(String id);
}
