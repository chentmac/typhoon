package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdService;
import service.impl.AdServiceImpl;


/**
 * Servlet implementation class DelAdServlet
 */
public class DelAdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdService adService=AdServiceImpl.getInstance();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		adService.deleteAdById(id);
	}


}
