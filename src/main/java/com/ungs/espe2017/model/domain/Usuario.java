package com.ungs.espe2017.model.domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Generated;

import com.ungs.espe2017.model.dao.IPostDAO;
import com.ungs.espe2017.model.dao.IUsuarioDAO;


@Entity
public class Usuario{

	private Long id;

    private String nombre;
    
    private String email;
    
    private String password;
    
    private Long cuil;
    
    private int cuit;
    
    public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getCuil() {
		return cuil;
	}

	public void setCuil(Long cuil) {
		this.cuil = cuil;
	}

	public int getCuit() {
		return cuit;
	}

	public void setCuit(int cuit) {
		this.cuit = cuit;
	}

	@Override
	public String toString() {
		return "El usuario: [id=" + id + ", nombre=" + nombre + ", email=" + email + ", password=" + password + ", cuil="
				+ cuil + ", cuit=" + cuit + "]";
	}
	
	@Override
	public Usuario clone() throws CloneNotSupportedException {
		return (Usuario) super.clone();
	}
	
	 public static void main(String[] args) {
			Usuario p = new Usuario();
			p.setEmail("Hola");;
			p.setPassword("hola");;
			p.setNombre("hola");
			IUsuarioDAO dao = new IUsuarioDAO();
			
			dao.crear(p);	
			
			List<Usuario> myList = new ArrayList<Usuario>();
			myList = dao.todos();
			
			 for(Usuario user : myList)
			 {
			    System.out.println(user.toString());
			 }
			
									
			}
    
    
}



