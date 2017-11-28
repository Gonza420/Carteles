package com.ungs.espe2017.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagers {
	
	
	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("connect.jpa");
	
	
	private EntityManagers()
	{			
	}
	
	public static EntityManager createEntityManager() {
	
		return entityManagerFactory.createEntityManager();
	}
	

}
