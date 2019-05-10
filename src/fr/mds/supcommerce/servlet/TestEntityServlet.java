package fr.mds.supcommerce.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.mds.supcommerce.entity.TestEntity;

@WebServlet(urlPatterns="/testEntity")
@SuppressWarnings("serial")
public class TestEntityServlet extends HttpServlet {
	
	private EntityManagerFactory emf;
	
	@Override
	public void init() throws ServletException {
		// init is executed 1 time so create the emf here because emf is thread safe
		emf = Persistence.createEntityManagerFactory("My-PU");
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TestEntity testEntity = new TestEntity();
		testEntity.setContent("Arbalete");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			// persist here
			em.persist(testEntity);
			t.commit();

		} finally {
			// finally is executed even if a return or an exception in the try is called
			if(t.isActive()) t.rollback();
			em.close();
		}
	}
	
	@Override
	public void destroy() {
		emf.close();
	}

}
