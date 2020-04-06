package mybatis_study.mappers;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import junit.framework.Assert;
import mybatis_study.dto.Gender;
import mybatis_study.dto.PhoneNumber;
import mybatis_study.dto.Student;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentMapperTest extends AbstractTest {
	private static StudentMapper dao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = StudentMapperImpl.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@Test
	public void test01SelectStudentByNO() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+ "()");
		Student student = new Student();
		student.setStudId(1);
		Student selectStudent = dao.selectStudentByNO(student);
		log.debug(selectStudent.toString());
		Assert.assertEquals(student.getStudId(), selectStudent.getStudId());
	}
	@Test
	public void test02SelectStudentByNoWithResultMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+ "()");
		Student student = new Student();
		student.setStudId(1);
		Student selectStudent = dao.selectStudentByNoWithResultMap(student);
		log.debug(selectStudent.toString());
		Assert.assertEquals(student.getStudId(), selectStudent.getStudId());
	}
	@Test
	public void test03SelectStudentByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+ "()");
		List<Student> list = dao.selectStudentByAll();
		Assert.assertNotNull(list);
		for(Student std : list) {
			log.debug(std.toString());
		}
	}
	@Test
	public void test04InsertStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+ "()");
		Student student = new Student();
		student.setStudId(3);
		student.setName("박인선");
		student.setEmail("dlstjs8246@naver.com");
		student.setPhone(new PhoneNumber("010-4175-3675"));
		Calendar cal = GregorianCalendar.getInstance();
		cal.set(1990, 9, 3);
		student.setDob(cal.getTime());
		int res = dao.insertStudent(student);
		Assert.assertEquals(1, res);
	}
	@Test
	public void test05UpdateStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+ "()");
		Student student = new Student();
		student.setStudId(3);
		student.setName("이상원");
		student.setEmail("sexyhotdog@naver.com");
		student.setPhone(new PhoneNumber("010-****-****"));
		Calendar cal = GregorianCalendar.getInstance();
		cal.set(1990, 11, 11);
		student.setDob(cal.getTime());
		int res = dao.updateStudent(student);
		Assert.assertEquals(1, res);
	}
	@Test
	public void test06DeleteStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+ "()");
		Student student = new Student();
		student.setStudId(3);
		int res = dao.deleteStudent(student);
		Assert.assertEquals(1, res);
	}
	@Test
	public void test07selectStudentByAllForResultMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+ "()");
		List<Student> list = dao.selectStudentByAllForResultMap();
		Assert.assertNotNull(list);
	}
	@Test
	public void test08selectStudentByAllForHashMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+ "()");
		List<Map<String,Object>> lists = dao.selectStudentByAllForHashMap();
		Assert.assertNotNull(lists);
		for(Map<String,Object> map : lists) {
			for(Entry<String,Object> e : map.entrySet()) {
				log.debug(String.format("%s -> %s", e.getKey(),e.getValue()));
			}
		}
	}
	@Test
	public void test09selectStudentByNoAssociation() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+ "()");
		Student student = new Student();
		student.setStudId(1);
		Student selStd = dao.selectStudentByNoAssociation(student);
		Assert.assertNotNull(selStd);
		log.debug(selStd.toString());
	}
	@Test
	public void test10insertEnumStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+ "()");
		Calendar newDate = GregorianCalendar.getInstance();
		Student student = new Student();
		student.setStudId(3);
		student.setName("test");
		student.setEmail("test@test.co.kr");
		student.setDob(newDate.getTime());
		student.setGender(Gender.FEMALE);
		int res = dao.insertEnumStudent(student);
		Assert.assertEquals(1, res);
		
		student.setStudId(4);
		student.setName("test4");
		student.setEmail("test4@test.co.kr");
		student.setPhone(new PhoneNumber("010-1234-1234"));
		student.setGender(Gender.MALE);
		int res1= dao.insertEnumStudent(student);
		Assert.assertEquals(1, res);
	}
	@Test
	public void test11selectAllStudentByMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+ "()");
		Map<String,String> maps = new HashMap<>();
		maps.put("name", "Timothy");
		maps.put("email", "timothy@gmail.com");
		Student student = dao.selectAllStudentByMap(maps);
		Assert.assertNotNull(student);
		
		maps.remove("email");
		student = dao.selectAllStudentByMap(maps);
		log.debug(student.toString());
		
		maps.clear();
		maps.put("email", "timothy@gmail.com");
		student = dao.selectAllStudentByMap(maps);
		log.debug(student.toString());
	}
	@Test
	public void test12selectStudentForMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+ "()");
		Map<Integer,Student> map = dao.selectStudentForMap(1);
		Assert.assertNotNull(map);
		for(Entry<Integer,Student> entry : map.entrySet()) {
			System.out.printf("key(%s) - value(%s)%n",entry.getKey(),entry.getValue().toString());
		}
	}
}
