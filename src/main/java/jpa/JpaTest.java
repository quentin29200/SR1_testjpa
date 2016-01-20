package jpa;

import domain.Person;

import javax.persistence.*;
import java.util.List;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {

			Person p2 = new Person();
			p2.setName("martin");
			manager.persist(p2);
			System.out.println("martin ajouté");


		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		String s = "SELECT e FROM Person as e where e.name=:name";
		
		Query q = manager.createQuery(s,Person.class);
		q.setParameter("name", "martin");
		List<Person> res = q.getResultList();
		
		System.err.println(res.size());
		System.err.println(res.get(0).getName());
		
		manager.close();
		factory.close();
	}

}
