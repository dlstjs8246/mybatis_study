package mybatis_study.mappers;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import mybatis_study.dto.UserPic;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserPicMapperTest {
	private static UserPicMapper dao;
	protected static final Log log = LogFactory.getLog(UserPicMapperTest.class);
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = UserPicMapperImpl.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@Test
	public void test01GetUserPic() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		UserPic userPic = new UserPic();
		userPic.setId(1);
		userPic.setName("박인선");
		userPic.setBio("put some lengthy bio here");
		userPic.setPic(getPicFile());
		int result = dao.insertUserPic(userPic);
		Assert.assertSame(1, result);
	}
	
	private byte[] getPicFile() {
		byte[] pic = null;
		File file = new File(System.getProperty("user.dir") + "\\images\\박인선.jpg");
		try(InputStream is = new FileInputStream(file);) {
			pic = new byte[is.available()];
			is.read(pic);
		}
		catch(FileNotFoundException e) {e.printStackTrace();}
		catch(IOException e) {e.printStackTrace();}
		return pic;
	}

	@Test
	public void test02InsertUserPic() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		UserPic userPic = dao.getUserPic(1);
		if(userPic.getPic()!=null) {
			File file = getPicFile(userPic);
			System.out.println("file path " + file.getAbsolutePath());
		}
		Assert.assertNotNull(userPic);
	}

	private File getPicFile(UserPic userPic) {
		File pics = new File(System.getProperty("user.dir") + "\\pic\\");
		if(!pics.exists()) {
			pics.mkdir();
		}
		File file = new File(pics,userPic.getName() + ".jpg");
		try(FileOutputStream output = new FileOutputStream(file)) {
			output.write(userPic.getPic());
		}
		catch(IOException e) {e.printStackTrace();}
		return file;
	}

}
