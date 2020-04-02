package mybatis_study.mappers;

import org.apache.ibatis.session.SqlSession;

import mybatis_study.dto.Tutor;
import mybatis_study.jdbc.MyBatisSqlSessionFactory;

public class TutorMapperImpl implements TutorMapper {
	private String namespace = "mybatis_study.mappers.TutorMapper";
	private static final TutorMapperImpl instance = new TutorMapperImpl();
	private SqlSession sqlSession;
	private TutorMapperImpl() {
		if(sqlSession==null) {
			this.sqlSession = MyBatisSqlSessionFactory.openSession();
		}
	};
	
	public static TutorMapperImpl getInstance() {
		return instance;
	}

	@Override
	public Tutor selectTutorByTutorId(Tutor tutor) {
		return sqlSession.selectOne(namespace + ".selectTutorByTutorId",tutor);
	}

}
