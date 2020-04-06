package mybatis_study.mappers;

import java.util.List;
import java.util.Map;

import mybatis_study.dto.Course;
import mybatis_study.dto.Tutor;

public interface TutorMapper {
	Tutor selectTutorByTutorId(Tutor tutor);
}
