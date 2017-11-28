package com.ungs.espe2017.view.controller;

import com.ungs.espe2017.model.domain.Usuario;
import com.ungs.espe2017.model.service.ServiciosUsuario;
import com.vaadin.data.Binder;
import com.vaadin.data.ValidationException;
import com.vaadin.navigator.View;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
 
public class Login extends VerticalLayout implements View  {
	//Titulo de la pagina
	private static final long serialVersionUID = 1L;

	public static final String NAME = "Loguearse";
	
	//Estructura
	private Label titulo = new Label("Inicia sesión aqui");
	private FormLayout formulario= new FormLayout();
	private HorizontalLayout botones= new HorizontalLayout();
	
	//Componentes
	private TextField email = new TextField("Ingresar tu mail:");
	private PasswordField password = new PasswordField("Ingresa tu contraseña");
	private Button registrar_button = new Button("Registrarse");
	private Button login_button = new Button("Inicio");
	
	//Servicios
	private Binder<Usuario> usuarioBinder = new Binder<>();		
	private ServiciosUsuario usuarioService = new ServiciosUsuario(); 
	
	public Login() {
		// TODO Auto-generated constructor stub
		super();
		cargarComponentes();
		cargarListeners();
		checkearRegistro();
	}
	
	private void  cargarComponentes() {
		
		formulario.addComponent(email);
		formulario.addComponent(password);
		botones.addComponent(registrar_button);
		botones.addComponent(login_button);
		addComponents(titulo,formulario,botones);
		
		
	}
	
	
	private void cargarListeners() {
		login_button.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void buttonClick(ClickEvent event) 
			{
				Usuario user= new Usuario();
				if(usuarioBinder.validate().isOk())
				{
					try {
					      usuarioBinder.writeBean(user);
					      System.out.println(user.toString());
					      if(usuarioService.seAceptaLogin(user.getEmail(),user.getPassword())) 
							{
					    	  VaadinSession.getCurrent().setAttribute("username", user.getEmail());
				    		  
					    	  getUI().getNavigator().addView(Inicio.NAME, new Inicio());
	    		                 		  
	    		              Page.getCurrent().setUriFragment("!"+Inicio.NAME);
					    	
	    		              getUI().getNavigator().navigateTo(Inicio.NAME);
							}					
							else {
							Notification.show( "El correo electrónico y la contraseña que ingresó no coinciden con nuestros registros. ",
						                  "Por favor, vuelva a verificar y vuelva a intentarlo.",
						                  Notification.Type.HUMANIZED_MESSAGE);
							}
					      
					    } 
					catch (ValidationException e) {
					      Notification.show("Person could not be saved, " +
					        "please check error messages for each field.");
					    }
				}
					
				else
				{
					// The component itself
					Notification.show("ERROR:",
			                  "Ingresa bien los campos",
			                  Notification.Type.HUMANIZED_MESSAGE);
				}
			}
		});

		registrar_button.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().addView(Registrar.NAME, new Registrar());
				getUI().getNavigator().navigateTo(Registrar.NAME);
				
			}
		});

	}
	
	private void checkearRegistro()
	{
		// Shorthand for cases without extra configuration
		usuarioBinder.forField(email)
		   .asRequired("Campo requerido")
		   .bind(Usuario::getEmail, Usuario::setEmail);
		
		usuarioBinder.forField(password)
		   .asRequired("Campo requerido")
		   .bind(Usuario::getPassword, Usuario::setPassword);
	}
	
	
}
