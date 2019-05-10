package fr.mds.supcommerce.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.mds.supcommerce.dao.ProductDao;
import fr.mds.supcommerce.entity.CategoryEntity;
import fr.mds.supcommerce.entity.TestEntity;
import fr.mds.supcommerce.model.Product;

@WebServlet(urlPatterns="/auth/addCategory")
public class AddCategoryServlet extends HttpServlet{
	
	private EntityManagerFactory emf;
	
	@Override
	public void init() throws ServletException {
		// init is executed 1 time so create the emf here because emf is thread safe
		emf = Persistence.createEntityManagerFactory("My-PU");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String categoryName = req.getParameter("name");
		
		CategoryEntity category = new CategoryEntity(categoryName);
		
		category.setName(categoryName);
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			// persist here
			em.persist(category);
			t.commit();

		} finally {
			// finally is executed even if a return or an exception in the try is called
			if(t.isActive()) t.rollback();
			em.close();
		}
		
		resp.sendRedirect("/SupCommerce/showCategory.jsp?id=" + category.getId());

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/auth/addCategory.jsp");
		rd.forward(req,  resp);
	}
	
	@Override
	public void destroy() {
		emf.close();
	}
}
