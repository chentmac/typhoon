package service.impl;

import dao.AdminDao;
import dao.impl.AdminDaoImpl;
import pojo.Admin;
import service.AdminService;

public class AdminServiceImpl implements AdminService {
	private AdminDao adminDao=new AdminDaoImpl();
	private static AdminServiceImpl instance =new AdminServiceImpl();
	private AdminServiceImpl() {}
	public static AdminServiceImpl getInstance() {
		return instance;
	}
	@Override
	public boolean login(Admin admin) {
		if(admin.getUserName()!=null&&admin.getPassword()!=null) {
			Admin a = adminDao.getAdminByName(admin.getUserName());
			if(a.getPassword()!=null) {
				boolean result=a.getPassword().equals(admin.getPassword());
				return result;
			}
		}
		return false;
	}
}
