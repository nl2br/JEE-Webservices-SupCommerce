package fr.mds.supcommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.mds.supcommerce.dao.ProductDao;
import fr.mds.supcommerce.model.Product;

@WebServlet(urlPatterns ="/listProduct")
@SuppressWarnings("serial")
public class ListProductServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ListProductServlet");
		List<Product> products = ProductDao.getAllProducts();
		req.setAttribute("products", products);
		RequestDispatcher rd = req.getRequestDispatcher("/listProduct.jsp");
		rd.forward(req,  resp);
	}

}
