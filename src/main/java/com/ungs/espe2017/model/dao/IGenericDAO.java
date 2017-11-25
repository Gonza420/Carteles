package com.ungs.espe2017.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ungs.espe2017.model.domain.Post;

public class IGenericDAO<E>  implements GenericDAO<E>{
	protected static EntityManagerFactory entityManagerFactory;

	public IGenericDAO() {
	}
	
	@Override
	public void guardar(E entidad) {
		EntityManagerFactory set = setUp();
		EntityManager entityManager = set.createEntityManager();
		entityManager.getTransaction().begin();
		
		entityManager.persist(entidad);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		tearDown();
		
	}
	
	public List<E> ObtenerTodos(String tabla, Class<E> entidad) {	
		setUp();
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
        List<E> lista = entityManager.createQuery(tabla, entidad).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        
        tearDown();
        
        return lista;
	}

	protected void tearDown() {
		entityManagerFactory.close();
	}

	protected EntityManagerFactory setUp() {
		return entityManagerFactory = Persistence.createEntityManagerFactory( "connect.jpa" );
	}

	@Override
	public E obtener(String id) {
		return null;
	}

	@Override
	public void eliminar(String id) {
	}

}