package mybatis_study.mappers;

import org.apache.ibatis.session.SqlSession;

import mybatis_study.dto.UserPic;
import mybatis_study.jdbc.MyBatisSqlSessionFactory;

public class UserPicMapperImpl implements UserPicMapper {
	private String namespace = "mybatis_study.mappers.UserPicMapper";
	private SqlSession sqlSession;
	private static final UserPicMapperImpl instance = new UserPicMapperImpl();
	private UserPicMapperImpl() {
		if(sqlSession==null) {
			sqlSession = MyBatisSqlSessionFactory.openSession();
		}
	}
	
	public static UserPicMapperImpl getInstance() {
		return instance;
	}

	@Override
	public int insertUserPic(UserPic userPic) {
		return sqlSession.insert(namespace + ".insertUserPic",userPic);
	}

	@Override
	public UserPic getUserPic(int id) {
		return sqlSession.selectOne(namespace + ".getUserPic",id);
	}

}
