package servlet;


import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdService;
import service.impl.AdServiceImpl;


/**
 * Servlet implementation class SendAds
 */
public class SendAds extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdService adService=AdServiceImpl.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendAds() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OutputStream out=response.getOutputStream();
		
		String name=request.getParameter("validation");
		if(name.equals("request")) {
			String ads=adService.sendAds();
			out.write(ads.getBytes());
		}
	
	}

}
