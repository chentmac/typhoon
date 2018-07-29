package dao;

import java.util.List;

import pojo.Ad;

public interface AdDao {

	public List<Ad> getAllAd();
	
	public int updateAd(Ad ad);
	
	public int addAd(Ad ad);
	
	public List<Ad> sendAds();
	
	public int deleteAdById(int i);
	
	public int findAdsCount();

	public List<Ad> getAdByPage(int begin, int end);
}
