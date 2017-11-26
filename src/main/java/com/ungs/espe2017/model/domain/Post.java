package com.ungs.espe2017.model.domain;


import java.io.Serializable;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.ungs.espe2017.model.dao.IPostDAO;


@Entity
public class Post{

    private Long id;

    private String contenido = "";
    
    private double calificacion ;
    
    private double cantCal;
    
    
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
    
    public void setCalificacion(double c){
    	this.calificacion = this.calificacion + c;
    	this.cantCal ++;
    }
    
    public double getCalificacion() {
    	return this.calificacion/this.cantCal;
    }
    
    @Override
    public String toString() {
        return contenido;
        		
    }
    
	@Override
	public Post clone() throws CloneNotSupportedException {
		return (Post) super.clone();
	}
	
    public static void main(String[] args) {
		Post p = new Post();
		p.setCalificacion(3);
		p.setContenido("dsa");
		IPostDAO dao = new IPostDAO();
		
		dao.crear(p);
		
		System.out.println("CANTIDAD POST" + dao.cantidadPost());	
		
		List<Post> myList = new ArrayList<Post>();
		myList = dao.todos();
		
		 for(Post post : myList)
		 {
		    System.out.println(post.calificacion);
		 }
		
								
		}

	
}
