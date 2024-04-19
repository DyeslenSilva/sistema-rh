	package sistema.rh.testebanco;

	import jakarta.persistence.EntityManager;
	import jakarta.persistence.EntityManagerFactory;
	import jakarta.persistence.Persistence;
	
	public class TesteConexaoJPA {
	
	    private static final String PERSISTENCE_UNIT_NAME = "sistema-rh";
	
	    public static void main(String[] args) {
	        // Obter o EntityManagerFactory a partir da unidade de persistência
	        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	
	        // Criar o EntityManager a partir do EntityManagerFactory
	        EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	        // Testar a conexão
	        try {
	            entityManager.getTransaction().begin();
	            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
	            entityManager.getTransaction().commit();
	        } catch (Exception e) {
	            System.err.println("Erro ao testar a conexão com o banco de dados: " + e.getMessage());
	            e.printStackTrace();
	        } finally {
	            // Fechar EntityManager
	            if (entityManager != null) {
	                entityManager.close();
	            }
	            // Fechar EntityManagerFactory
	            if (entityManagerFactory != null) {
	                entityManagerFactory.close();
	            }
	        }
	    }
	}
