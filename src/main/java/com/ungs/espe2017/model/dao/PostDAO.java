package com.ungs.espe2017.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ungs.espe2017.model.domain.Post;


public class PostDAO {
		
	
		
		
		
		
		public static void guardarPost(Post p){
			EntityManagerFactory emf;
			emf = Persistence.createEntityManagerFactory("PersistenciaPost");
			EntityManager entityManager = emf.createEntityManager();
			entityManager.getTransaction().begin();	
			entityManager.persist(p);
			entityManager.getTransaction().commit();
			entityManager.close();
		}
		
		public List<Post> recuperarPost (){
			EntityManagerFactory emf;
			emf = Persistence.createEntityManagerFactory( "PersistenciaPost" );
			EntityManager entityManager = emf.createEntityManager();
			entityManager.getTransaction().begin();
	        List<Post> result = entityManager.createQuery( "from Post", Post.class ).getResultList();
	        entityManager.getTransaction().commit();
	        entityManager.close();
	        return result;
		}
		private static void imprimirtodo(){
			EntityManagerFactory emf;
			emf = Persistence.createEntityManagerFactory( "PersistenciaPost" );
			EntityManager entityManager = emf.createEntityManager();
			List<Post> emps = entityManager.createQuery("FROM Post").getResultList();
			System.out.println("Hay" + emps.size() + "posts");
		}
		
		
 public static void main(String[] args) {
		// TODO Auto-generated method stub
	 	Post p = new Post();
	 	p.setContenido("probando dao");
	 	guardarPost(p);
	 	imprimirtodo();
	}

}
