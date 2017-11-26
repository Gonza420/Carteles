package com.ungs.espe2017.model.dao;

/**
 * GenericDAO implementation class.
 * 
 * @author AP
 */

import java.util.List;

public interface GenericDAO<T> {
	public void crear(T t);
	public void eliminar(T t);	
	public T porId(long id);	
	public List<T> todos();
	public void actualizar(T t);
}