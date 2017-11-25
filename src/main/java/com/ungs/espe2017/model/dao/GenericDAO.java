package com.ungs.espe2017.model.dao;

/**
 * GenericDAO implementation class.
 * 
 * @author AP
 */

import java.util.List;

public interface GenericDAO<E> {
	public void guardar(E entidad);
	public void eliminar(String id);
	public E obtener(String id);
	public List<E> ObtenerTodos(String tabla, Class<E> entidad);
}