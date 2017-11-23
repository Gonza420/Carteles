package com.ungs.espe2017.view.controller;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;


/*
 * public class Login extends LoginForm implements View  {
 	public static final String NAME = "Logueate con tu usuario";
 	public Login()
	{
		LoginForm login = new LoginForm();
		
	}
}
*/
 

@SuppressWarnings("serial")
public class Login extends VerticalLayout implements View  {

	 public static final String NAME = "Logueate con tu usuario";
	  
	private TextField user_field = new TextField("Ingresar tu usuario:");
	private PasswordField password_field = new PasswordField("Ingresa tu contraseña");
	private Button registrar_button = new Button("Registrarse");
	private Button login_button = new Button("Aceptar");
	
	public Login() {
		// TODO Auto-generated constructor stub
		addComponents(user_field,password_field,registrar_button,login_button);
		login_button.addClickListener(null);
		login_button.addClickListener(null);
	}
	 
	
	
	
	
    
    
}
