package br.com.gerenciador.reserva.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("reserva");
	private static EntityManager entityManager;
	
	static{
		entityManager = factory.createEntityManager();
	}
	
	public static EntityManager getEntityManager() {
		return entityManager;
	}
	
	public static EntityTransaction getEntityTransaction() {
		return entityManager.getTransaction();
	}
	
}