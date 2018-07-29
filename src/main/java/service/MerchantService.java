package service;


import java.util.List;

import pojo.Merchant;
import pojo.Page;


public interface MerchantService {
public List<Merchant> getNoCheckMerchant();
	
	public List<Merchant> getNoPassMerchant();
	
	public List<Merchant> getPassMerchant();
	
	public List<Merchant> getCheckBackMerchant();
	
	public List<Merchant> getAllMerchant();
	
	public boolean setStatusById(String id,Integer status);
	
	public boolean addMerchant(Merchant merchant);
	
	public Merchant getMerchantById(String shopId);
	
	public Merchant getMerchantByIdCard(String idCard);
	
	public void CheckMerchant(Merchant merchant);
	
	public Page<Merchant> getNoCheckMerchantsByPage(int currentPage,int pageSize);

	public Page<Merchant> getAgreeMerchantsByPage(int currentPage, int pageSize);

	public Page<Merchant> getDisagreeMerchantsByPage(int currentPage, int pageSize);
}
