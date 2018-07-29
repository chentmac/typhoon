package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Merchant;
import service.MerchantService;
import service.impl.MerchantServiceImpl;


/**
 * Servlet implementation class StatusCheck
 */
public class StatusCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MerchantService merchantService=MerchantServiceImpl.getInstance();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String shopId = request.getParameter("queryStatus");
		if(shopId!=null&&!shopId.equals("")) {
			Merchant merchant = merchantService.getMerchantById(shopId);
			ServletOutputStream out = response.getOutputStream();
			out.write((merchant.getStatus()+"").getBytes());
		}
	}
}
