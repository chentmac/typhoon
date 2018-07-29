package servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import pojo.Ad;
import pojo.Merchant;
import pojo.Page;
import service.MerchantService;
import service.impl.MerchantServiceImpl;


/**
 * Servlet implementation class InitServlet
 */
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MerchantService merchantService=MerchantServiceImpl.getInstance();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage=Integer.parseInt(request.getParameter("currentPage"));
		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		Page<Merchant> page=merchantService.getNoCheckMerchantsByPage(currentPage,pageSize);
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Pragma","No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", -10);
		PrintWriter out=response.getWriter();
		ObjectMapper mapper=new ObjectMapper();
		String jsonStr=mapper.writeValueAsString(page);
		out.print(jsonStr);
        out.flush();
	}

}
