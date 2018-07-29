package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdService;
import service.impl.AdServiceImpl;


/**
 * Servlet implementation class AdAgreeServlet
 */
public class AdAgreeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdService adService=AdServiceImpl.getInstance();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		int state=Integer.parseInt(request.getParameter("state"));
		adService.updateAd(id, state);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
