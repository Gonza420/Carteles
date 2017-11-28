package com.ungs.espe2017.model.service;

import com.ungs.espe2017.model.domain.Usuario;

public class ServiciosUsuario {

	public boolean seAceptaLogin(String email, String password){
		if(email.equals( buscarUsuario(email).getEmail()))
			return true;
		else
		return false;
	}
	
	
	public boolean seAceptaRegistro(Usuario user){
		if (buscarUsuario(user.getEmail()).equals(null))
		{
			guardarUsuario(user);
			return true;
		}
		else
			//return false;
			//**IMPORTANTE CUANDO CREE EL BUSCAR CAMBIAR A FALSE
			return true;
	}
	
	public Usuario buscarUsuario(String email_user) {
		Usuario busqueda_user=new Usuario();
		busqueda_user.setEmail(email_user);
		return busqueda_user;
		
	}
	
	private void guardarUsuario(Usuario guardado_user) {
		
	}
	

	

}
