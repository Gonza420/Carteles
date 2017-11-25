package com.ungs.espe2017.view.controller;

import com.ungs.espe2017.model.service.ServiciosUsuario;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
 
public class Login extends VerticalLayout implements View  {
	//Titulo de la pagina
	public static final String NAME = "Loguearse";
	
	//Estructura
	private Label titulo = new Label("Inicia sesión aqui");
	private FormLayout formulario= new FormLayout();
	private HorizontalLayout botones= new HorizontalLayout();
	
	//Componentes
	private ServiciosUsuario usuarioService = new ServiciosUsuario();
	private TextField user_field = new TextField("Ingresar tu mail:");
	private PasswordField password_field = new PasswordField("Ingresa tu contraseña");
	private Button registrar_button = new Button("Registrarse");
	private Button login_button = new Button("Inicio");
	private PopupView popup = new PopupView("Pop it up", new VerticalLayout());
	
	public Login() {
		// TODO Auto-generated constructor stub
		super();
		cargarComponentes();
		cargarListeners();
	}
	
	private void  cargarComponentes() {
		
		formulario.addComponent(user_field);
		formulario.addComponent(password_field);
		botones.addComponent(registrar_button);
		botones.addComponent(login_button);
		addComponents(titulo,formulario,botones);
		
		
		addComponent(popup);
		
	}
	
	
	private void cargarListeners() {
		login_button.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void buttonClick(ClickEvent event) {
				if(usuarioService.seAceptaLogin(formulario)) {
					getUI().getNavigator().navigateTo(Inicio.NAME);
				}					
				else {
					popup.setPopupVisible(true);
					VerticalLayout popupContent = new VerticalLayout();
					popupContent.addComponent(new TextField("No se pudo acceder al usuario"));
					popupContent.addComponent(new Button("cerrar"));

					// The component itself
					PopupView popup = new PopupView("Pop it up", popupContent);
					addComponent(popup);
				}		
			}
		});

		registrar_button.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(Registrar.NAME);
			}
		});

	}
	
	private void cargarPopUp() {
		// Content for the PopupView

		// The component itself
		
		//addComponent(popup);
	}
}
