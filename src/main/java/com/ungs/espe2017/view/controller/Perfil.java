package com.ungs.espe2017.view.controller;

import com.ungs.espe2017.model.domain.Usuario;
import com.ungs.espe2017.model.service.ServiciosUsuario;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class Perfil extends VerticalLayout implements View  {
	//Titulo de la pagina
		public static final String NAME = "Perfil";
		
		private static final long serialVersionUID = 1L;
		
		private ServiciosUsuario service = new ServiciosUsuario();
		
	    
		
		//Estructuras
		
		
		//Componentes

	public Perfil() {
		// TODO Auto-generated constructor stub
		super();
		addComponent(new Label("ESTE ES EL PERFIL"));
		Usuario usuario=service.obtenerUsuario((String) VaadinSession.getCurrent().getAttribute("username"));
		addComponent(new Label(usuario.toString()));
	}

}
