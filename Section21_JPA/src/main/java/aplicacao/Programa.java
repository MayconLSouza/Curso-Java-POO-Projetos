package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

		/* Inserindo objeto 
		Pessoa p = new Pessoa(null, "John Doe", "johndoe@email.com");
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		*/

		// Recuperando objeto
		Pessoa p = em.find(Pessoa.class, 2);
		System.out.println(p);

		/* Removendo objeto 
		Pessoa p = em.find(Pessoa.class, 2);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		*/
		
		System.out.println("DONE!");
		em.close();
		emf.close();
	}

}
