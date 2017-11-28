package com.ungs.espe2017.model.dao;

import javax.persistence.EntityManager;
import com.ungs.espe2017.model.domain.Usuario;

public class IUsuarioDAO extends DAOJPA<Usuario> implements UsuarioDAO {

	public long cantidadUsuarios() {
		EntityManager entityManager = EntityManagers.createEntityManager();
		return entityManager.createQuery("SELECT COUNT(p) FROM Usuario p",
				Long.class).getSingleResult();

	}
}
