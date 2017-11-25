package com.ungs.espe2017.model.dao;

import javax.persistence.EntityManager;

import com.ungs.espe2017.model.domain.Post;

public class IPostDAO extends DAOJPA<Post> implements PostDAO {

	public long cantidadPost() {
		EntityManager entityManager = EntityManagers.createEntityManager();
		return entityManager.createQuery("SELECT COUNT(p) FROM Post p",
				Long.class).getSingleResult();

	}
}