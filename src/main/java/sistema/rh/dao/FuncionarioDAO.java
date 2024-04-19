package sistema.rh.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sistema.rh.model.Funcionario;

public class FuncionarioDAO {	
	
	private EntityManagerFactory emf =null;
	private EntityManager em = null;
	
	public FuncionarioDAO() {
		emf = Persistence.createEntityManagerFactory("sistema-rh");
		em = emf.createEntityManager();
	}
	
	public void cadastroFuncionario(Funcionario func) {
		em.getTransaction().begin();
		em.persist(func);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public List<Funcionario> getAllFuncionarios(){
		em.getTransaction().begin();
		List<Funcionario> todosOsFuncionarios =
				em.createQuery("select f from Funcionario f", Funcionario.class)
				.getResultList();
		
		em.getTransaction().commit();
		return todosOsFuncionarios;
	}
	
	public Funcionario consultaFuncionarioPorCPF(String cpf) {
		em.getTransaction().begin();
		Funcionario funcionario = em.createQuery("select f from Funcionario f where f.cpf = :cpf", Funcionario.class)
				.setParameter("cpf", cpf).getSingleResult();
		em.getTransaction().commit();
		return funcionario;
	}
	
	public Funcionario consultaFuncionarioPorCEPF(String cepf) {
		em.getTransaction().begin();
		Funcionario funcionario = em.createQuery("select f from Funcionario f where f.cepf = :cepf", Funcionario.class)
				.setParameter("cepf", cepf).getSingleResult();
	em.getTransaction().commit();
	return funcionario;
	}
	
}
