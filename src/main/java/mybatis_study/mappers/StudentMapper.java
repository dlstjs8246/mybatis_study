package mybatis_study.mappers;

import java.util.List;
import java.util.Map;

import mybatis_study.dto.Student;

public interface StudentMapper {
	Student selectStudentByNO(Student student);
	Student selectStudentByNoWithResultMap(Student student);
	List<Student> selectStudentByAll();
	int insertStudent(Student student);
	int updateStudent(Student student);
	int deleteStudent(Student student);
	List<Student> selectStudentByAllForResultMap();
	List<Map<String,Object>> selectStudentByAllForHashMap();
	Student selectStudentByNoAssociation(Student student);
}
