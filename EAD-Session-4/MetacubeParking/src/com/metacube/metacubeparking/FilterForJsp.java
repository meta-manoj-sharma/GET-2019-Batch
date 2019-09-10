package com.metacube.metacubeparking;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FilterForJsp.
 */
@WebFilter("/GetPass.jsp")
public class FilterForJsp implements Filter {

	/**
	 * Instantiates a new filter for jsp.
	 */
	public FilterForJsp() {
	}

	public void destroy() {
	}

	/**
	 * Do filter.
	 * @param request the request
	 * @param response the response
	 * @param chain the chain
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request1 = (HttpServletRequest) request;
		HttpServletResponse response1 = (HttpServletResponse) response;
		System.out.println("HELLO I AM IN FiLTER2");
		HttpSession session = request1.getSession();
		String email = (String) session.getAttribute("Email");
		if (email != null) {
			chain.doFilter(request1, response1);
		} else {
			response1.sendRedirect("Resistration.html");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {		
	}
}
