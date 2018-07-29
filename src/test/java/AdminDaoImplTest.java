

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.AdminDao;
import dao.impl.AdminDaoImpl;
import pojo.Admin;


public class AdminDaoImplTest {

	private static AdminDao adminDao;
	@BeforeClass
	public static void init() {
		adminDao=new AdminDaoImpl();
	}
	@Test
	public void testGetAdminByName() {
		Admin admin=adminDao.getAdminByName("jason");
		System.out.println(admin.toString());
		Assert.assertTrue(admin!=null);
	}
	
}
