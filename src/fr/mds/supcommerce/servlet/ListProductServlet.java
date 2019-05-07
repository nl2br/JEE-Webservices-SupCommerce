package fr.mds.supcommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.mds.supcommerce.dao.ProductDao;
import fr.mds.supcommerce.model.Product;

@SuppressWarnings("serial")
public class ListProductServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Product> productLists = ProductDao.getAllProducts();
		
		PrintWriter out = resp.getWriter();
		for(Product product : productLists) {
			out.println(product.toString());
		}
	}

}
