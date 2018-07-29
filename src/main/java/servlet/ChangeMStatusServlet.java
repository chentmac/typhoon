package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import service.MerchantService;
import service.impl.MerchantServiceImpl;

/**
 * Servlet implementation class ChangeMStatusServlet
 */
public class ChangeMStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MerchantService merchantService=MerchantServiceImpl.getInstance(); 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		int status =Integer.parseInt(request.getParameter("status"));
		boolean result=merchantService.setStatusById(id, status);
		PrintWriter out=response.getWriter();
		if(!result) {
			response.setContentType("text/html;charset=UTF-8");
			response.setHeader("Pragma","No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", -10);
			out.print("sorry,some error happened,please reflush this page!");
	        out.flush();
		}
	}

}
