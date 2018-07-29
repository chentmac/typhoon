package service.impl;


import java.util.List;

import dao.AdDao;
import dao.impl.AdDaoImpl;
import pojo.Ad;
import pojo.Page;
import service.AdService;



public class AdServiceImpl implements AdService {

	private AdDao adDao=new AdDaoImpl();
	private static AdServiceImpl instance = new AdServiceImpl();

	private AdServiceImpl() {
	}

	public static AdServiceImpl getInstance() {
		return instance;
	}
	@Override
	public List<Ad> getAllAds() throws Exception{
		List<Ad> ads=adDao.getAllAd();
		return ads;
	}
	@Override
	public void updateAd(int id, int state) {
		Ad ad=new Ad();
		ad.setId(id);
		ad.setState(state);
		adDao.updateAd(ad);
	}
	@Override
	public boolean addAd(Ad ad) {
		int result=adDao.addAd(ad);
		return (result>0)?true:false;
	}
	@Override
	public String sendAds() {
		List<Ad> ads=adDao.sendAds();
		StringBuffer sb=new StringBuffer();
		for (Ad ad : ads) {
			sb.append(ad.getShopId()+"-");
		}
		return sb.toString();
	}

	@Override
	public boolean deleteAdById(int id) {
		int result=adDao.deleteAdById(id);
		return (result>0)?true:false;
	}

	@Override
	public Page<Ad> getAdsByPage(int currentPage,int pageSize) {
		Page<Ad> page=new Page<Ad>();
		page.setCurrentPage(currentPage);
		page.setPageSize(pageSize);
		int totalCount=adDao.findAdsCount();
		page.setTotalCount(totalCount);
		int totalPage=0;
		if (totalCount%pageSize==0){
            totalPage=totalCount/pageSize;
        }else {
            totalPage=totalCount/pageSize+1;
        }
		page.setTotalPage(totalPage);
		int begin= (currentPage-1)*pageSize;
		List<Ad> list=adDao.getAdByPage(begin,begin+pageSize);
		page.setDataList(list);
		return page;
	}

}
