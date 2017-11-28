package com.ungs.espe2017.model.service;

import java.util.ArrayList;
import java.util.List;
import com.ungs.espe2017.model.dao.IUsuarioDAO;
import com.ungs.espe2017.model.domain.Usuario;

public class ServiciosUsuario {
	private IUsuarioDAO dao = new IUsuarioDAO();
	
	 
    private synchronized void save(Usuario entry) {
    	
    	dao.crear(entry);
    }
    
    private List<Usuario> findAll() {
		List<Usuario> myList = new ArrayList<Usuario>();
		myList = dao.todos();
		return myList;
	}
    
    
    public Usuario buscarUsuario (String e) {
    	List<Usuario> lista = dao.todos();
    	for (Usuario user : lista) {
    		if(user.getEmail().equals(e))
    		return user; 
    	
    	}
    	return null;
	}
	

	public boolean seAceptaLogin(String email, String password){
//		if(email.equals( buscarUsuario(email).getEmail()))
//			return true;
//		else
		return true;
	}
	
	
	public boolean seAceptaRegistro(Usuario user){
//		if (buscarUsuario(user.getEmail()).equals(null))
//		{
//			save(user);
//			return true;
//		}
//		else
			return true;
			
	}
	
	
	
	

	

}
