package com.ungs.espe2017.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class IGenericDAO<E>  implements GenericDAO<E>{
	protected static EntityManagerFactory entityManagerFactory;

	public IGenericDAO() {
	}
	
	@Override
	public void guardar(E entidad) {
		setUp();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		entityManager.persist(entidad);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		tearDown();
		
	}

	protected void tearDown() {
		entityManagerFactory.close();
	}


	protected void setUp() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "connect.jpa" );
	}


	@Override
	public E obtener(String id) {
		return null;
	}

	@Override
	public void eliminar(String id) {
	}


	@Override
	public List<E> leer() {
		return null;
	}

}