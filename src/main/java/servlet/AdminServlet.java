package servlet;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Admin;
import service.AdminService;
import service.impl.AdminServiceImpl;
import util.JsonOut;
import util.JsonParse;
import util.JsonParseByJackson;


/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService adminService=AdminServiceImpl.getInstance();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// 读取请求内容
				BufferedReader br = request.getReader();
				String line = null;
				StringBuilder sb = new StringBuilder();
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				JsonParse<Admin> jsonUtil=new JsonParseByJackson<>();
				Admin admin = jsonUtil.parseJsonToObject(Admin.class, sb.toString());
				boolean login = adminService.login(admin);
				if(login) {
					request.getSession().setAttribute("admin", admin);
					response.setContentType("text/html;charset=UTF-8");
					response.setHeader("Pragma","No-cache");
					response.setHeader("Cache-Control", "no-cache");
					response.setDateHeader("Expires", -10);
					PrintWriter out = null;
			        try {
			        	JsonParse json = new JsonParseByJackson();
			            out = response.getWriter();
			            String jsonStr=json.parseObjectToJson(admin);
			            out.print(jsonStr);
			            out.flush();
			        } catch (IOException e) {
			            e.printStackTrace();
			        }finally{
			            out.close();
			        }
				}else {
					JsonOut.outJson(request, response, null);
				}
	}
}
