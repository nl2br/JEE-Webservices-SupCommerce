package fr.mds.supcommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.mds.supcommerce.dao.ProductDao;
import fr.mds.supcommerce.model.Product;

@WebServlet(urlPatterns ="/auth/basicInsert")
@SuppressWarnings("serial")
public class InsertSomeProductServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product product = new Product("product", "desc", 15.90f);
		ProductDao.addProduct(product);
		
		PrintWriter out = resp.getWriter();
		out.println(product.toString());
		
	}

}
