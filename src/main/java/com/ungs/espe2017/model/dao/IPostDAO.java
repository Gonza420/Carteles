package com.ungs.espe2017.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.ungs.espe2017.model.domain.Post;


public class IPostDAO extends IGenericDAO<Post> implements PostDAO {

	@Override
	public List<Post> leer() {
		setUp();
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
        List<Post> posts = entityManager.createQuery( "from Post", Post.class ).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        
        tearDown();
        
        return posts;
	}
	
	
	
	@Override
	public void guardar(Post entidad) {
		IGenericDAO<Post> igd = new IGenericDAO<>();
		igd.guardar(entidad);
	}
	@Override
	public Post obtener(String id) {
		return null;
	}
	@Override
	public void eliminar(String id) {
	}

	//TEST
//	public static void main(String[] args) {
//		Post prueba = new Post("Prueba");
//		IPostDao ipd = new IPostDao();
//		ipd.guardar(prueba);
//	}

	
}