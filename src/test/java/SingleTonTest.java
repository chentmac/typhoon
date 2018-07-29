import org.junit.Assert;
import org.junit.Test;

import service.impl.AdServiceImpl;
import service.impl.AdminServiceImpl;
import service.impl.MerchantServiceImpl;

public class SingleTonTest {

	@Test
	public void testAdminServiceImpl() {
		AdminServiceImpl singletonOne =  AdminServiceImpl.getInstance();
		
		AdminServiceImpl singletonTwo =  AdminServiceImpl.getInstance();
		
		Assert.assertTrue(singletonOne.equals(singletonTwo));
	}
	@Test
	public void testAdServiceImpl() {
		AdServiceImpl singletonOne =  AdServiceImpl.getInstance();
		
		AdServiceImpl singletonTwo =  AdServiceImpl.getInstance();
		
		Assert.assertTrue(singletonOne.equals(singletonTwo));
	}
	@Test
	public void testMerchantServiceImpl() {
		MerchantServiceImpl singletonOne = MerchantServiceImpl.getInstance();
		
		MerchantServiceImpl singletonTwo = MerchantServiceImpl.getInstance();
		
		Assert.assertTrue(singletonOne.equals(singletonTwo));
	}
}
