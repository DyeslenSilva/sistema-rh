package sistema.rh.utils.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import sistema.rh.model.utils.Estado;

public class EstadoDAO {

	private EntityManagerFactory emf= null;
	private EntityManager em = null;
	
	public EstadoDAO() {
		emf = Persistence.createEntityManagerFactory("sistema-rh");
		em = emf.createEntityManager();
	}
	
	
	public void cadastroEstado(Estado estado) {
		em.getTransaction().begin();
		em.persist(estado);
		em.getTransaction().commit();
		em.close();
	}
	

	public List<String> getEstados() {
	    String hql = "SELECT e.sigla FROM Estado e";
	    TypedQuery<String> query = em.createQuery(hql, String.class);
	    List<String> estados = query.getResultList();
	    return estados;
	}

	
}
