

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.AdDao;
import dao.impl.AdDaoImpl;
import pojo.Ad;


public class AdDaoImplTest {

	private static AdDao adDao;

	@BeforeClass
	public static void init() {
		adDao = new AdDaoImpl();
	}
	@Test
	public void testAddAd() {
		Ad ad=new Ad(null,"adf","daf","fadfa","dfaf",12.3,1);
		int result = adDao.addAd(ad);
		Assert.assertTrue(result==1);
		
	}
	@Test
	public void findAllAds() {
		List<Ad> ads = adDao.getAllAd();
		Assert.assertTrue(ads != null);
		Assert.assertTrue(!ads.isEmpty());
		System.out.println(ads.toString());
	}
	@Test
	public void updateAd() {
		Ad ad=new Ad(1521,"你是谁","fadfa","daf","daf",12.3,100);
		int result=adDao.updateAd(ad);
		Assert.assertTrue(result==1);
	}
	@Test
	public void deleteAd() {
		int result=adDao.deleteAdById(1521);
		Assert.assertTrue(result==1);
	}
	@Test
	public void findAdsCount() {
		int result=adDao.findAdsCount();
		System.out.println(result);
		Assert.assertTrue(result>0);
	}
	@Test
	public void getAdByPage() {
		List<Ad> ads=adDao.getAdByPage(0, 10);
		for (Ad ad : ads) {
			System.out.println(ad.toString());
		}
	}

}
