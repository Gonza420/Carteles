package com.ungs.espe2017.view.controller;

import com.vaadin.navigator.View;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class Inicio extends VerticalLayout implements View  {
	//Titulo de la pagina
	public static final String NAME = "Inicio";
	
	private static final long serialVersionUID = 1L;
    
	
	//Estructuras
	
	
	//Componentes
	
	private Label secure;

    private Label currentUser;

    private Button perfil = new Button ("Mi Perfil");
    
    private Button postear = new Button ("Postear aqui!!!");

    private Button logout = new Button ("Cerrar Sesion");
	
	Inicio()
	{
		super();
		cargarComponentes();
		cargarListeners();
		

	}
	
private void  cargarComponentes() {
		
	addComponent(new Label("ESETE ES EL INICIO "));
	secure = new Label("Inicio");
	
	currentUser = new Label("Usuario: "+(String) VaadinSession.getCurrent().getAttribute("username"));
	
	addComponent(secure);
	
	addComponent(currentUser);
	
	addComponent(perfil);

	addComponent(postear);
	
	addComponent(logout);
		
		
	}
	
	private void cargarListeners()
	{
		
		
		perfil.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void buttonClick(ClickEvent event) {
				//Page.getCurrent().setUriFragment("!"+Perfil.NAME);
				getUI().getNavigator().addView(Perfil.NAME, new Perfil());		    	
				getUI().getNavigator().navigateTo(Perfil.NAME);
			}
		});
		
		postear.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void buttonClick(ClickEvent event) {
				//Page.getCurrent().setUriFragment("!"+Postear.NAME);
				getUI().getNavigator().addView(Postear.NAME, new Postear());		    	
				getUI().getNavigator().navigateTo(Postear.NAME);
			}
		});

		
		logout.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void buttonClick(ClickEvent event) {

				getUI().getNavigator().removeView(Inicio.NAME);
				
				getUI().getNavigator().removeView(Perfil.NAME);
				
				getUI().getSession().getSession().invalidate();
				String location = Page.getCurrent().getLocation().toString();
				String loginPageUrl = location.substring(0, location.indexOf('#'));
				getUI().getPage().setLocation(loginPageUrl);
				
				
			}
		});

	}
	
	
	
	

		
		    

}