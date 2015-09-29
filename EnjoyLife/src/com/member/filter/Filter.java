package com.member.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.model.MemberService;
import com.member.model.MemberVO;

@WebFilter(
	urlPatterns={"/indexMember.jsp","/blog/*","/partner/*","/comment/*","/view/*","/attrac/*","/activityPage/*"}
//	"/display/*"
)	
public class Filter implements javax.servlet.Filter {
	private FilterConfig config;
	private MemberService service;
	@Override
	public void destroy() {
	
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
			HttpServletRequest request = (HttpServletRequest) req;
			HttpServletResponse response = (HttpServletResponse) resp;
			HttpSession session = request.getSession();
//			Cookie[] cookies = request.getCookies();
//			  if (cookies != null) {
//				  System.out.println("進入COOKIE");
//				  String username ="訪客";
//				  String password ="";
//				  service = new MemberService();
//				  for (Cookie cookie :cookies) {
//						if (cookie.getName().equals("username"))
//							username = cookie.getValue();
//						System.out.println(username);
//						if (cookie.getName().equals("password"))
//							password = cookie.getValue();
//						System.out.println(password);
//						 if (service.login(username, password)!=null) {				    	 
//					    	 String path =request.getContextPath();
//					         response.sendRedirect(path+"/index.jsp");
//					         System.out.println("登入"); 
//					        }
//					    } 
//					}			  			    
			MemberVO bean = (MemberVO) session.getAttribute("member");
			System.out.println(1);
			
			if(bean!=null){
				System.out.println(7);
				chain.doFilter(request, response);
			}else{
				System.out.println(2);
				String uri = request.getRequestURI();
				session.setAttribute("dest", uri);
				
				String path =request.getContextPath();
				response.sendRedirect(path+"/indexfix.jsp");
			}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config=config;
	}

}
