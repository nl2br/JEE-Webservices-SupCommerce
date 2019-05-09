package fr.mds.supcommerce.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.mds.supcommerce.dao.ProductDao;
import fr.mds.supcommerce.model.Product;

@WebServlet(urlPatterns="/auth/addProduct")
public class AddProductServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String productName = req.getParameter("name");
		String productDesc = req.getParameter("description");
		String productPrice = req.getParameter("price");
		
		float priceFloat = 0;
		try {
			priceFloat = Float.parseFloat(productPrice);
		} catch (Exception e) {
			resp.getWriter().println("float required for price");
			return;
		}
		
		Product product = new Product(productName,productDesc,priceFloat);
		ProductDao.addProduct(product);
		
		resp.sendRedirect("/SupCommerce/showProduct.jsp?id=" + product.getId());

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/auth/addProduct.jsp");
		rd.forward(req,  resp);
	}
}
