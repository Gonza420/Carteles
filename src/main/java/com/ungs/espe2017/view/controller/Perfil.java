package com.ungs.espe2017.view.controller;

import com.vaadin.navigator.View;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class Perfil extends VerticalLayout implements View  {
	//Titulo de la pagina
		public static final String NAME = "Perfil";
		
		private static final long serialVersionUID = 1L;
		
	    
		
		//Estructuras
		
		
		//Componentes

	public Perfil() {
		// TODO Auto-generated constructor stub
		super();
		addComponent(new Label("ESETE ES EL PERFIL GATO"));
	}

}
