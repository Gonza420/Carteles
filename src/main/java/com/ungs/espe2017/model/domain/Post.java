package com.ungs.espe2017.model.domain;


import java.io.Serializable;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.ungs.espe2017.model.dao.IGenericDAO;


@Entity
public class Post  extends IGenericDAO<Post> implements Serializable, Cloneable{

    private Long id;

    private String contenido = "";
    
    
    public Post(){
    	
    }
    @Id
    @GeneratedValue
    public Long getId(){
    	return id;
    }
    
    public String getContenido(){
    	return contenido;
    }
    
    public void setId(Long id){
    	this.id = id;
    }
    
    public void setContenido(String c){
    	this.contenido = c;
    }
    
    @Override
    public String toString() {
        return contenido;
        		
    }
    
	@Override
	public Post clone() throws CloneNotSupportedException {
		return (Post) super.clone();
	}
	//TEST
	public static void main(String[] args) {
		Post prueba = new Post();
		prueba.guardar(prueba);
		prueba.ObtenerTodos("from post", (Class<Post>) prueba.getClass());
	}
}

