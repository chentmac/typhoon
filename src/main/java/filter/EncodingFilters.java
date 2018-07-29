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


/**
 * Servlet Filter implementation class EncodingFilters
 */
public class EncodingFilters implements Filter {

	private String encoding;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.encoding=filterConfig.getServletContext().getInitParameter("encoding");
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		  HttpServletRequest req = (HttpServletRequest)request;
		  HttpServletResponse resp = (HttpServletResponse)response;
		  
		  /*
		   * 判断在web.xml文件中是否配置了编码格式的信息
		   * 如果为空，则设置编码格式为配置文件中的编码格式
		   * 否则编码格式设置为GBK
		   */
		  if(this.encoding != null && !this.encoding.equals("")){
			  req.setCharacterEncoding(this.encoding);
			  resp.setCharacterEncoding(this.encoding);
		  }else{
			  req.setCharacterEncoding("UTF-8");
			  resp.setCharacterEncoding("UTF-8");
		  }
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
