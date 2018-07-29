package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Admin;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@SuppressWarnings("unused")
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse) response;
		String path=req.getServletPath();
		HttpSession session=req.getSession();
		Admin admin=(Admin) session.getAttribute("admin");
		String[] urls= {"/login.html","/json",".js",".css",".ico",".jpg","png","/admin","/SendAds","/StatusCheck"};
		boolean flag=true;
		for (String string : urls) {
			if(path.indexOf(string)!=-1) {
				flag=false;
				break;
			}
		}
		if(flag) {
			if(admin!=null) {
				chain.doFilter(request, response);
			}else {
				resp.sendRedirect("login.html");
			}
		}else {
			chain.doFilter(request, response);
		}
	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
