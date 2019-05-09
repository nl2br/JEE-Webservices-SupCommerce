package fr.mds.supcommerce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("/SupCommerce/login.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("from form : " + req );
		String login = (String) req.getParameter("email");
		String password = (String) req.getParameter("password");
		
		HttpSession session = req.getSession();
		session.setAttribute("login", login);
		session.setAttribute("password", password);
		
		resp.sendRedirect("/SupCommerce/listProduct");		
		
	}
}