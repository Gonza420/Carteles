package com.ungs.espe2017.model.service;

import com.ungs.espe2017.model.domain.Usuario;
import com.vaadin.ui.FormLayout;

public class ServiciosUsuario {

	public boolean seAceptaLogin(Usuario user){
		if(user.getEmail().equals( buscarUsuario(user).getEmail()))
			return true;
		else
		return false;
	}
	
	
	public boolean seAceptaRegistro(Usuario user){
		if(user.getEmail().equals( buscarUsuario(user).getEmail()))
			return false;
		else
			guardarUsuario(user);
		return true;
	}
	
	public Usuario buscarUsuario(Usuario busqueda_user) {
		
		return busqueda_user;
		
	}
	
	private void guardarUsuario(Usuario guardado_user) {
		
	}
	

	

}
