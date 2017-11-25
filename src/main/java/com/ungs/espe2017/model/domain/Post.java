package com.ungs.espe2017.model.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.ungs.espe2017.model.dao.IPostDAO;


@Entity
public class Post{

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
    
    public static void main(String[] args) {
		Post p = new Post();
		
		IPostDAO dao = new IPostDAO();
		dao.crear(p);
		
		System.out.println("CANTIDAD POST" + dao.cantidadPost());				
								
		}

}

