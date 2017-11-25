package com.ungs.espe2017.model.domain;


import java.io.Serializable;







import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Post implements Serializable, Cloneable{

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
}
