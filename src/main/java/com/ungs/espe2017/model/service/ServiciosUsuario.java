package com.ungs.espe2017.model.service;

import java.util.List;

import com.ungs.espe2017.model.dao.IUsuarioDAO;
import com.ungs.espe2017.model.domain.Usuario;

public class ServiciosUsuario {
	private IUsuarioDAO dao = new IUsuarioDAO();
	
	 
    private synchronized void save(Usuario entry) {
    	
    	dao.crear(entry);
    }
    
    public Usuario obtenerUsuario (String email) {
    	List<Usuario> lista = dao.todos();
    	for (Usuario user : lista) {
    		if(user.getEmail().equals(email))
    		return user; 
    	
    	}
    	return new Usuario();
	}
	
    public boolean seAceptaLogin (String email, String password) {
    	List<Usuario> lista = dao.todos();
    	for (Usuario user : lista) {
    		if(user.getEmail().equals(email) && user.getPassword().equals(password))
    		return true; 
    	
    	}
    	return false;
	}
	
	
	
	public boolean seAceptaRegistro(Usuario usuario){
    	List<Usuario> lista = dao.todos();
    	for (Usuario user : lista) {
    		if(user.getEmail().equals(usuario.getEmail()))
    		return false; 
    	
    	}
			save(usuario);
			return true;
			
	}
	
	
    public static void main(String[] args) {
    	IUsuarioDAO dao = new IUsuarioDAO();
    	List<Usuario> lista = dao.todos();
    	for (Usuario user : lista) {
    		if(user.getEmail().equals(null)) 
    		System.out.println("Existe:"); 

    	
    	}
		
								
		}

	

	

}
