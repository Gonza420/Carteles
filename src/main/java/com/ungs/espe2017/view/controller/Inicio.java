package com.ungs.espe2017.view.controller;

import com.vaadin.navigator.View;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class Inicio extends VerticalLayout implements View  {
	//Titulo de la pagina
	public static final String NAME = "Inicio";
	
	//Estructuras
	
	//Componentes
	
	Inicio()
	{
		super();
		addComponent(new Label("ESETE ES EL INICIO GATO"));
	}
}