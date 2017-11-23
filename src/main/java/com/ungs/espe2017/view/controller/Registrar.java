package com.ungs.espe2017.view.controller;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class Registrar extends VerticalLayout implements View  {

		public static final String NAME = "Crea tu usuario";
		  
		
		private TextField user_field = new TextField("Ingresar tu usuario:");
		//private TextField user_field = new TextField("Ingresar tu usuario:");

		private PasswordField password_field = new PasswordField("Ingresa tu contraseña");
		private PasswordField password_verif = new PasswordField("Reingresa tu contraseña");
		private Button login_button = new Button("Registrar");
		
		public Registrar() {
			// TODO Auto-generated constructor stub
			addComponents(user_field,password_field,login_button);
			login_button.addClickListener(null);
		}

}
