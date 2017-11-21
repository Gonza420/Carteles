package com.ungs.espe2017.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ungs.espe2017.model.domain.Usuario;


public class UsuarioDAO {
		
		
		public static void guardarUsuario(Usuario u){
			EntityManagerFactory emf;
			emf = Persistence.createEntityManagerFactory("PersistenciaUsuario");
			EntityManager entityManager = emf.createEntityManager();
			entityManager.getTransaction().begin();	
			entityManager.persist(u);
			entityManager.getTransaction().commit();
			entityManager.close();
		}
		
		public List<Usuario> recuperarUsuario (){
			EntityManagerFactory emf;
			emf = Persistence.createEntityManagerFactory( "PersistenciaUsuario" );
			EntityManager entityManager = emf.createEntityManager();
			entityManager.getTransaction().begin();
	        List<Usuario> result = entityManager.createQuery( "from Usuario", Usuario.class ).getResultList();
	        entityManager.getTransaction().commit();
	        entityManager.close();
	        return result;
		}
		private static void imprimirtodo(){
			EntityManagerFactory emf;
			emf = Persistence.createEntityManagerFactory( "PersistenciaUsuario" );
			EntityManager entityManager = emf.createEntityManager();
			List<Usuario> emps = entityManager.createQuery("FROM Usuario").getResultList();
			System.out.println("Hay" + emps.size() + "usuarios");
		}
		
		
 public static void main(String[] args) {
		// TODO Auto-generated method stub
	 	Usuario u = new Usuario();
	 	u.setNombre("probando dao");
	 	guardarUsuario(u);
	 	imprimirtodo();
	}

}