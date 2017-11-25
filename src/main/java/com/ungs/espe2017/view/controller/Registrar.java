package com.ungs.espe2017.view.controller;

import com.ungs.espe2017.model.service.ServiciosUsuario;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class Registrar extends VerticalLayout implements View  {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		//Titulo de la pagina
		public static final String NAME = "Registrarse";
		
		//Estructuras
		private Label titulo = new Label("Inicia sesión aqui");
		
		private FormLayout formulario= new FormLayout();
		
		private HorizontalLayout botones= new HorizontalLayout();
		
		//Componentes
		private ServiciosUsuario usuarioService = new ServiciosUsuario();
		
		private TextField nombre = new TextField("Ingresa tu nombre");
	    
	    private TextField email =  new TextField("Ingresa tu mail");
	    
	    private PasswordField password =  new PasswordField("Ingresa tu password");
	    
	    private PasswordField password_control =  new PasswordField("Confirma tu password");
	    
	    private TextField cuil =  new TextField("Ingresa tu CUIL");
		
	    private Button registrok_button = new Button("Registrar");
	    
		private Button atras_button = new Button("Atras");
		
		private PopupView popup = new PopupView("Pop it up", new VerticalLayout());
		
				
		public Registrar() {
			// TODO Auto-generated constructor stub
			super();
			cargarComponentes();
			cargarListeners();
			
		}
		
		private void  cargarComponentes() {
			
			formulario.addComponent(email);
			formulario.addComponent(nombre);
			formulario.addComponent(cuil);
			formulario.addComponent(password);
			formulario.addComponent(password_control);
			botones.addComponent(atras_button);
			botones.addComponent(registrok_button);
			addComponents(titulo,formulario,botones);
			addComponent(popup);
			
			
		}
		
		private void cargarListeners() {
			registrok_button.addClickListener(new Button.ClickListener() {
				private static final long serialVersionUID = 1L;
				@Override
				public void buttonClick(ClickEvent event) 
				{
					if(checkearRegistro())
					{
						if(usuarioService.seAceptaRegistro(formulario)) 
						{
							getUI().getNavigator().navigateTo(Login.NAME);
						}					
						else {
						popup.setPopupVisible(true);
						VerticalLayout popupContent = new VerticalLayout();
						popupContent.addComponent(new TextField("No se pudo registrar el usuario"));
						popupContent.addComponent(new Button("cerrar"));
				
						// The component itself
						PopupView popup = new PopupView("Pop it up", popupContent);
						addComponent(popup);
						}
					}
						
					
				}
			});

			atras_button.addClickListener(new Button.ClickListener() {
				private static final long serialVersionUID = 1L;
				@Override
				public void buttonClick(ClickEvent event) {
					getUI().getNavigator().navigateTo(Login.NAME);
				}
			});

		}
		
		private void cargarPopUp() {
			// Content for the PopupView

			// The component itself
			
			//addComponent(popup);
		}
		
		private boolean checkearRegistro()
		{
			
			
			return true;
		}


}
