package com.ungs.espe2017.view.controller;

import javax.servlet.annotation.WebServlet;

import com.ungs.espe2017.model.service.ServiciosUsuario;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

@Theme("mytheme")
public class MyUI extends UI {
	private static final long serialVersionUID = 1L;
	private Navigator navigator;
	
	
	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class TpUIServlet extends VaadinServlet {
		private static final long serialVersionUID = 1L;
	}
	
	
	@Override
	protected void init(VaadinRequest request) {
		
		navigator = new Navigator(this,this);
		navigator.addView(Login.NAME, new Login());
		navigator.addView(Registrar.NAME, new Registrar());
		navigator.addView(Inicio.NAME, new Inicio());
		navigator.navigateTo(Login.NAME);
		
	}

}