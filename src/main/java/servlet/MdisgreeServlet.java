//package servlet;
//
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import service.MerchantService;
//import service.impl.MerchantServiceImpl;
//
//
///**
// * Servlet implementation class MdisgreeServlet
// */
//public class MdisgreeServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private MerchantService merchantService=MerchantServiceImpl.getInstance(); 
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		String id=request.getParameter("id");
//		int status =Integer.parseInt(request.getParameter("status"));
//		merchantService.setStatusById(id, status);
//	}
//}
