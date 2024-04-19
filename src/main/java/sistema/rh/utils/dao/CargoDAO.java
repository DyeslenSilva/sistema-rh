package sistema.rh.utils.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import sistema.rh.model.utils.Cargo;
import sistema.rh.model.utils.NivelCargo;

public class CargoDAO {
		
		private EntityManagerFactory emf;
		private EntityManager em;
		
		
		public CargoDAO() {
			emf = Persistence.createEntityManagerFactory("sistema-rh");
			em = emf.createEntityManager();
		}
		
		public void cadastroCargo(Cargo cargo){
			em.getTransaction().begin();
			em.persist(cargo);
			em.getTransaction().commit();
			em.close();
		}
		
		public void cadastroNivel(NivelCargo nivelCargo) {
			em.getTransaction().begin();
			em.persist(nivelCargo);
			em.getTransaction().commit();
			em.close();
		}
		
		public List<String> getCargos() {
		    String hql = "SELECT e.nomeCargo FROM Cargo e";
		    TypedQuery<String> query = em.createQuery(hql, String.class);
		    List<String> cargos = query.getResultList();
		    return cargos;
		}
		
		
		public List<String> getNivelCargo(){
			String hql = "SELECT e.nivelCargo FROM NivelCargo e";
			TypedQuery<String> query = em.createQuery(hql,String.class);
			List<String> nivelCargo = query.getResultList();
			return nivelCargo;
		}

}
