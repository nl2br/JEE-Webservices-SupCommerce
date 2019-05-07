package fr.mds.supcommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.mds.supcommerce.dao.ProductDao;
import fr.mds.supcommerce.model.Product;

@SuppressWarnings("serial")
public class ShowProductServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ShowProductServlet - doGet : req.getParameter(\"id\") " + req.getParameter("id"));
		Long id = Long.parseLong(req.getParameter("id"));
		
		List<Product> productLists = new ArrayList<Product>();
		productLists = ProductDao.getAllProducts();
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		for(Product product : productLists) {
			System.out.println("ShowProductServlet - doGet : product: " + product.getId() + " id: " + id);
			if(product.getId().equals(id)) {
				System.out.println("ShowProductServlet - doGet : find");
				out.println(product.toString());
			}
		}
	}

}
