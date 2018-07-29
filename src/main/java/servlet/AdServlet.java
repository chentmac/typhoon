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
import pojo.Page;
import service.AdService;
import service.impl.AdServiceImpl;


/**
 * Servlet implementation class AdServlet
 */
public class AdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdService adService=AdServiceImpl.getInstance();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int currentPage=Integer.parseInt(request.getParameter("currentPage"));
			int pageSize=Integer.parseInt(request.getParameter("pageSize"));
			Page<Ad> page=adService.getAdsByPage(currentPage,pageSize);
//			List<Ad> ads=adService.getAllAds();
			response.setContentType("text/html;charset=UTF-8");
			response.setHeader("Pragma","No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", -10);
			PrintWriter out=response.getWriter();
			ObjectMapper mapper=new ObjectMapper();
			String jsonStr=mapper.writeValueAsString(page);
			out.print(jsonStr);
	        out.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
