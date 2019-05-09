package fr.mds.supcommerce.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticateFilter extends HttpFilter {
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		super.doFilter(req, res, chain);
		
		HttpSession session = req.getSession();
		String login = (String) session.getAttribute("login");
		String password = (String) session.getAttribute("password");
		System.out.println("from session, login: " + login + " and pass: " + password);
		if(login != null && password != null) {
			// continue the route
			System.out.println("auth ok, continue");
			chain.doFilter(req, res);
		}else {
			// redirect
			System.out.println("no pass, no login : redirect to /login");
			res.sendRedirect("/SupCommerce/login.html");
		}
		
		
		
		
	}
}
