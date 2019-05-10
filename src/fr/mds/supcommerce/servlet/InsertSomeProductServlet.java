package fr.mds.supcommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.mds.supcommerce.dao.ProductDao;
import fr.mds.supcommerce.entity.CategoryEntity;
import fr.mds.supcommerce.entity.ProductEntity;
import fr.mds.supcommerce.model.Product;

@WebServlet(urlPatterns = "/auth/basicInsert")
@SuppressWarnings("serial")
public class InsertSomeProductServlet extends HttpServlet {

	private EntityManagerFactory emf;

	@Override
	public void init() throws ServletException {
		// init is executed 1 time so create the emf here because emf is thread safe
		emf = Persistence.createEntityManagerFactory("My-PU");

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryEntity category = new CategoryEntity("salé");
		ProductEntity product = new ProductEntity("product", "desc", 15.90f, category);

		EntityManager em = emf.createEntityManager();

		EntityTransaction t = em.getTransaction();

		try {
			t.begin();
			// persist here
			em.persist(product);
			t.commit();

		} finally {
			// finally is executed even if a return or an exception in the try is called
			if (t.isActive())
				t.rollback();
			em.close();
		}

		

	}

}
