package dao;


import java.util.List;

import pojo.Merchant;


public interface MerchantDao {

	public List<Merchant> getAllMerchant();
	
	public Merchant getMerchantById(String id);
	
	public int updateMerchant(Merchant merchant);
	
	public int addMerchant(Merchant merchant);

	public Merchant checkMerchantByIdCard(String idCard);

	public Merchant getMerchantByShopId(String shopId);

	public int deleteMerchantByShopId(String shopId);


	public List<Merchant> getNoCheckMerchantByPage(int begin, int end);

	public int findNoCheckMerchantCount();

	public int findAgreeMerchantCount();

	public List<Merchant> getAgreeMerchantByPage(int begin, int i);

	public int findDisagreeMerchantCount();

	public List<Merchant> getDisagreeMerchantByPage(int begin, int i);
}
