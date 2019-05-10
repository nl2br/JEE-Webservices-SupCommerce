package fr.mds.supcommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.mds.supcommerce.dao.ProductDao;
import fr.mds.supcommerce.model.Product;

@WebServlet(urlPatterns="/showCategory")
@SuppressWarnings("serial")
public class ShowCategoryServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ShowCategoryServlet - doGet : req.getParameter(\"id\") " + req.getParameter("id"));
		
		Long id = 0L;
		try {
			id = Long.parseLong(req.getParameter("id"));
		} catch (NumberFormatException e) {
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("Error " + e);
			return;
		}
		
		//TODO afficher les category
		Product product = ProductDao.findProduct(id);
		
		if( product == null) {
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("Error, product doesn exist");
			return;
		}
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println(product);
		
		
		

	}

}
