package mybatis.mappers;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConfig {
	
	private static SqlSessionFactory sqlMapper = null;
	
	static {
		try {
			String resource = "mybatis/SqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);

			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("MyBatisConfig 초기화 중 예외 발생 : " + e.getMessage());
		}
	}
	
	public static SqlSessionFactory getSqlMapper() {
		return sqlMapper;
	}
}
