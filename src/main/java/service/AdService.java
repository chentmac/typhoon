package service;


import java.util.List;

import pojo.Ad;
import pojo.Page;


public interface AdService {

	public List<Ad> getAllAds() throws Exception;
	public void updateAd(int id,int state);
	public boolean addAd(Ad ad);
	public String sendAds();
	public boolean deleteAdById(int id);
	public Page<Ad> getAdsByPage(int currentPage,int pageSize);
}
