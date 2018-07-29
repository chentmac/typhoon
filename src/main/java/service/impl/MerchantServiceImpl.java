package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.MerchantDao;
import dao.impl.MerchantDaoImpl;
import pojo.Ad;
import pojo.Merchant;
import pojo.Page;
import service.MerchantService;

public class MerchantServiceImpl implements MerchantService {

	private Merchant merchant;
	private List<Merchant> merchants;
	private MerchantDao merchantDao = new MerchantDaoImpl();

	private static MerchantServiceImpl instance = new MerchantServiceImpl();

	private MerchantServiceImpl() {
	}

	public static MerchantServiceImpl getInstance() {
		return instance;
	}

	@Override
	public List<Merchant> getNoCheckMerchant() {
		List<Merchant> result = new ArrayList<>();
		merchants = merchantDao.getAllMerchant();
		for (Merchant m : merchants) {
			if (m.getStatus() == 0) {
				result.add(m);
			}
		}
		return result;
	}

	@Override
	public List<Merchant> getNoPassMerchant() {
		List<Merchant> result = new ArrayList<>();
		merchants = merchantDao.getAllMerchant();
		for (Merchant m : merchants) {
			if (m.getStatus() == 3) {
				result.add(m);
			}
		}
		return result;
	}

	@Override
	public List<Merchant> getPassMerchant() {
		List<Merchant> result = new ArrayList<>();
		merchants = merchantDao.getAllMerchant();
		for (Merchant m : merchants) {
			if (m.getStatus() == 1) {
				result.add(m);
			}
		}
		return result;
	}

	@Override
	public List<Merchant> getCheckBackMerchant() {
		List<Merchant> result = new ArrayList<>();
		merchants = merchantDao.getAllMerchant();
		for (Merchant m : merchants) {
			if (m.getStatus() == 2) {
				result.add(m);
			}
		}
		return result;
	}

	@Override
	public List<Merchant> getAllMerchant() {
		merchants = merchantDao.getAllMerchant();
		for (Merchant merchant : merchants) {
			merchant.getPicture();
		}
		return merchants;
	}

	@Override
	public boolean setStatusById(String id, Integer status) {
		merchant = merchantDao.getMerchantById(id);
		merchant.setStatus(status);
		int result = merchantDao.updateMerchant(merchant);
		return (result > 0) ? true : false;
	}

	@Override
	public boolean addMerchant(Merchant merchant) {
		merchant.setStatus(0);
		int result = merchantDao.addMerchant(merchant);
		return (result > 0) ? true : false;
	}

	@Override
	public Merchant getMerchantById(String shopId) {
		Merchant merchant = merchantDao.getMerchantById(shopId);
		return merchant;
	}

	@Override
	public Merchant getMerchantByIdCard(String idCard) {
		Merchant merchant = merchantDao.checkMerchantByIdCard(idCard);
		return merchant;
	}

	@Override
	public void CheckMerchant(Merchant merchant) {
		// TODO Auto-generated method stub
		MerchantService merchantService = new MerchantServiceImpl();
		Merchant merchant1 = merchantService.getMerchantByIdCard(merchant.getIdCard());
		if (merchant.getShopName().equals(merchant1.getShopName())) {
			merchant.setStatus(2);
		}

	}

	@Override
	public Page<Merchant> getNoCheckMerchantsByPage(int currentPage, int pageSize) {
		Page<Merchant> page=new Page<Merchant>();
		page.setCurrentPage(currentPage);
		page.setPageSize(pageSize);
		int totalCount=merchantDao.findNoCheckMerchantCount();
		page.setTotalCount(totalCount);
		int totalPage=0;
		if (totalCount%pageSize==0){
            totalPage=totalCount/pageSize;
        }else {
            totalPage=totalCount/pageSize+1;
        }
		page.setTotalPage(totalPage);
		int begin= (currentPage-1)*pageSize;
		List<Merchant> list=merchantDao.getNoCheckMerchantByPage(begin,begin+pageSize);
		page.setDataList(list);
		return page;
	}

	@Override
	public Page<Merchant> getAgreeMerchantsByPage(int currentPage, int pageSize) {
		Page<Merchant> page=new Page<Merchant>();
		page.setCurrentPage(currentPage);
		page.setPageSize(pageSize);
		int totalCount=merchantDao.findAgreeMerchantCount();
		page.setTotalCount(totalCount);
		int totalPage=0;
		if (totalCount%pageSize==0){
            totalPage=totalCount/pageSize;
        }else {
            totalPage=totalCount/pageSize+1;
        }
		page.setTotalPage(totalPage);
		int begin= (currentPage-1)*pageSize;
		List<Merchant> list=merchantDao.getAgreeMerchantByPage(begin,begin+pageSize);
		page.setDataList(list);
		return page;
	}

	@Override
	public Page<Merchant> getDisagreeMerchantsByPage(int currentPage, int pageSize) {
		Page<Merchant> page=new Page<Merchant>();
		page.setCurrentPage(currentPage);
		page.setPageSize(pageSize);
		int totalCount=merchantDao.findDisagreeMerchantCount();
		page.setTotalCount(totalCount);
		int totalPage=0;
		if (totalCount%pageSize==0){
            totalPage=totalCount/pageSize;
        }else {
            totalPage=totalCount/pageSize+1;
        }
		page.setTotalPage(totalPage);
		int begin= (currentPage-1)*pageSize;
		List<Merchant> list=merchantDao.getDisagreeMerchantByPage(begin,begin+pageSize);
		page.setDataList(list);
		return page;
	}

}
