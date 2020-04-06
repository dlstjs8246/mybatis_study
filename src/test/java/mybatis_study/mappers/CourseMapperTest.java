package mybatis_study.mappers;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import mybatis_study.dto.Course;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseMapperTest {
	private static CourseMapper dao;
	protected static final Log log = LogFactory.getLog(CourseMapperTest.class);
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = CourseMapperImpl.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@Test
	public void test01selectCoursesByCondition() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		GregorianCalendar cal = new GregorianCalendar(2013, 1, 1);
		Map<String,Object> map = new HashMap<>();
		map.put("tutorId",1);
		List<Course> courses = dao.selectCoursesByCondition(map);
		Assert.assertNotNull(courses);
		for(Course c : courses) log.trace(c.toString());
	}
	@Test
	public void test02selectCoursesByCondition() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		GregorianCalendar cal = new GregorianCalendar(2013, 1, 1);
		Map<String,Object> map = new HashMap<>();
		map.put("courseName","%java%");
		List<Course> courses = dao.selectCoursesByCondition(map);
		Assert.assertNotNull(courses);
		for(Course c : courses) log.trace(c.toString());
	}
	@Test
	public void test03selectCoursesByCondition() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		GregorianCalendar cal = new GregorianCalendar(2013, 1, 1);
		Map<String,Object> map = new HashMap<>();
		map.put("startDate",cal.getTime());
		List<Course> courses = dao.selectCoursesByCondition(map);
		Assert.assertNotNull(courses);
		for(Course c : courses) log.trace(c.toString());
	}
	@Test
	public void test04selectCaseCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Map<String,Object> map = new HashMap<>();
		map.put("searchBy", "Tutor");
		map.put("tutodId", 1);
		List<Course> courses = dao.selectCaseCourses(map);
		Assert.assertNotNull(courses);
		for(Course c : courses) log.trace(c.toString());
		map.replace("searchBy", "CourseName");
		map.remove("tutorId");
		map.put("courseName", "%java%");
		courses = dao.selectCoursesByCondition(map);
		Assert.assertNotNull(courses);
		for(Course c : courses) log.trace(c.toString());
	}
	@Test
	public void test05selectWhereCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Map<String,Object> map = new HashMap<>();
		List<Course> courses = dao.selectWhereCourses(map);
		Assert.assertNotNull(courses);
		for(Course c : courses) log.debug(c.toString());
		map.put("tutorId", 1);
		courses = dao.selectWhereCourses(map);
		Assert.assertNotNull(courses);
		for(Course c : courses) log.debug(c.toString());
		map.put("courseName", "%java%");
		courses = dao.selectWhereCourses(map);
		for(Course c : courses) log.debug(c.toString());
		map.clear();
		map.put("endDate", new Date());
		courses = dao.selectWhereCourses(map);
		for(Course c : courses) log.debug(c.toString());
	}
	@Test
	public void test06selectTrimCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Map<String,Object> map = new HashMap<>();
		List<Course> courses = dao.selectTrimCourses(map);
		Assert.assertNotNull(courses);
		for(Course c : courses) log.debug(c.toString());
		map.put("tutorId", 1);
		courses = dao.selectTrimCourses(map);
		Assert.assertNotNull(courses);
		for(Course c : courses) log.debug(c.toString());
		map.clear();
		map.put("courseName", "%java%");
		courses = dao.selectTrimCourses(map);
		Assert.assertNotNull(courses);
		for(Course c : courses) log.debug(c.toString());
		map.put("tutorId", 1);
		courses = dao.selectTrimCourses(map);
		Assert.assertNotNull(courses);
		for(Course c : courses) log.debug(c.toString());
	}
	@Test
	public void test07selectCoursesForeachByTutors() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Integer> tutorIds = new ArrayList<>();
		tutorIds.add(1);
		tutorIds.add(2);
		Map<String,Object> map = new HashMap<>();
		map.put("tutorIds",tutorIds);
		List<Course> courses = dao.selectCoursesForeachByTutors(map);
		Assert.assertNotNull(courses);
		for(Course c : courses) log.trace(c.toString());
	}
	@Test
	public void test08insertCourses() {
		List<Course> tutors = new ArrayList<>();
		tutors.add(new Course(4,"mysql","database",new Date(),new Date(), 3));
		tutors.add(new Course(5,"mssql","database",new Date(),new Date(), 3));
		tutors.add(new Course(6,"mariaDb","database",new Date(),new Date(), 4));
		Map<String,Object> map = new HashMap<>();
		map.put("tutors",tutors);
		int res = dao.insertCourses(map);
		Assert.assertEquals(3, res);
	}
	@Test
	public void test09deleteCourses() {
		List<Integer> courseIds = new ArrayList<>();
		courseIds.add(4);
		courseIds.add(5);
		courseIds.add(6);
		Map<String,Object> map = new HashMap<>();
		map.put("courseIds",courseIds);
		int res = dao.deleteCourses(map);
		Assert.assertEquals(3, res);
	}
}
