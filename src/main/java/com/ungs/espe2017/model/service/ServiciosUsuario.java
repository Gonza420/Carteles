package com.ungs.espe2017.model.service;

import com.ungs.espe2017.model.domain.Usuario;
import com.vaadin.ui.FormLayout;

public class ServiciosUsuario {

	public boolean seAceptaLogin(FormLayout form_login) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean seAceptaRegistro(FormLayout form_registro) {
		// TODO Auto-generated method stub
		//return new Usuario();
		return false;
	}
	
	public Usuario traerUsuario(String gmail_user) {
		
		return new Usuario();
	}
	

	

}
