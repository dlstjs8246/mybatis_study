package mybatis_study.mappers;

import static org.junit.Assert.*;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;
import mybatis_study.dto.Course;
import mybatis_study.dto.Tutor;

public class TutorMapperTest {
	private static TutorMapper dao;
	protected static final Log log = LogFactory.getLog(TutorMapperTest.class);
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = TutorMapperImpl.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@Test
	public void testSelectTutorByTutorId() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Tutor findTutor = new Tutor();
		findTutor.setTutorId(1);
		Tutor tutor = dao.selectTutorByTutorId(findTutor);
		Assert.assertEquals(tutor.getTutorId(), tutor.getName());
		log.trace(tutor.getTutorId() + " : " + tutor.getName());
		for(Course c : tutor.getCourses()) {
			log.trace(c.toString());
		}
	}

}
