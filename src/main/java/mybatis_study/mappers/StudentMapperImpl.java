package mybatis_study.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mybatis_study.dto.Student;
import mybatis_study.jdbc.MyBatisSqlSessionFactory;

public class StudentMapperImpl implements StudentMapper {
	private String namespace = "mybatis_study.mappers.StudentMapper";
	private static final StudentMapperImpl instance = new StudentMapperImpl();
	private SqlSession sqlSession;
	private StudentMapperImpl() {
		if(sqlSession==null) {
			this.sqlSession = MyBatisSqlSessionFactory.openSession();
		}
	}
	
	public static StudentMapperImpl getInstance() {
		return instance;
	}

	@Override
	public Student selectStudentByNO(Student student) {
		return sqlSession.selectOne(namespace + ".selectStudentByNO",student);
	}

	@Override
	public Student selectStudentByNoWithResultMap(Student student) {
		return sqlSession.selectOne(namespace + ".selectStudentByNoWithResultMap",student);
	}

	@Override
	public List<Student> selectStudentByAll() {
		return sqlSession.selectList(namespace + ".selectStudentByAll");
	}

	@Override
	public int insertStudent(Student student) {
		int res = sqlSession.insert(namespace + ".insertStudent",student);
		return res;
	}
	@Override
	public int deleteStudent(Student student) {
		return sqlSession.delete(namespace + ".deleteStudent",student);
	}

	@Override
	public int updateStudent(Student student) {
		return sqlSession.update(namespace + ".updateStudent",student);
	}

	@Override
	public List<Student> selectStudentByAllForResultMap() {
		return sqlSession.selectList(namespace + ".selectStudentByAllForResultMap");
	}

	@Override
	public List<Map<String, Object>> selectStudentByAllForHashMap() {
		return sqlSession.selectList(namespace + ".selectStudentByAllForHashMap");
	}

	@Override
	public Student selectStudentByNoAssociation(Student student) {
		return sqlSession.selectOne(namespace + ".selectStudentByNoAssociation",student);
	}
}
