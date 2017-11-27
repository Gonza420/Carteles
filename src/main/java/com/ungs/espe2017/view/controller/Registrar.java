package com.ungs.espe2017.view.controller;

import com.ungs.espe2017.model.domain.Usuario;
import com.ungs.espe2017.model.service.ServiciosUsuario;
import com.vaadin.data.Binder;
import com.vaadin.data.ValidationException;
import com.vaadin.data.ValidationResult;
import com.vaadin.data.Validator;
import com.vaadin.data.ValueContext;
import com.vaadin.data.converter.StringToIntegerConverter;
import com.vaadin.data.converter.StringToLongConverter;
import com.vaadin.navigator.View;
import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
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
			
		private TextField nombre = new TextField("Ingresa tu nombre");
	    
	    private TextField email =  new TextField("Ingresa tu mail");
	    
	    private PasswordField password =  new PasswordField("Ingresa tu password");
	    
	    private PasswordField password_control =  new PasswordField("Confirma tu password");
	    
	    private TextField cuil =  new TextField("Ingresa tu CUIL");
		
	    private Button registrok_button = new Button("Registrar");
	    
		private Button atras_button = new Button("Atras");
		
		private PopupView popup = new PopupView("Pop it up", new VerticalLayout());
		
		//Servicios
		private Binder<Usuario> usuarioBinder = new Binder<>();
		
		private ServiciosUsuario usuarioService = new ServiciosUsuario();
		
				
		public Registrar() {
			// TODO Auto-generated constructor stub
			super();
			cargarComponentes();
			cargarListeners();
			checkearRegistro();
			
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
					Usuario user= new Usuario();
					if(usuarioBinder.validate().isOk())
					{
						try {
						      usuarioBinder.writeBean(user);
						      if(usuarioService.seAceptaRegistro(user)) 
								{
									getUI().getNavigator().navigateTo(Login.NAME);
								}					
								else {
								Notification.show("ERROR:",
							                  "Este usuario no se pudo registrar, intente nuevamente",
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

			atras_button.addClickListener(new Button.ClickListener() {
				private static final long serialVersionUID = 1L;
				@Override
				public void buttonClick(ClickEvent event) {
					getUI().getNavigator().navigateTo(Login.NAME);
				}
			});

		}
		
		private void checkearRegistro()
		{
			// Shorthand for cases without extra configuration
			usuarioBinder.forField(email)
			   .asRequired("Campo requerido")
			   .bind(Usuario::getEmail, Usuario::setEmail);
			usuarioBinder.forField(nombre)
			   .asRequired("Campo requerido")
			   .bind(Usuario::getNombre, Usuario::setNombre);
			usuarioBinder.forField(password)
			   .asRequired("Campo requerido")
			   .bind(Usuario::getPassword, Usuario::setPassword);
			usuarioBinder.forField(password_control)
			   .asRequired("Campo requerido")
			   .withValidator(validadorPassword)
			   .bind(Usuario::getPassword, Usuario::setPassword);
				
			
			// long way of binding, usually used for more complex bindings
			usuarioBinder.forField(cuil)
			
				.withValidator ( validadorCuil )
	            .withConverter ( new StringToLongConverter ( "Debe contener solamente numeros" ) )
	            //.withValidator ( convertidoCuil )
				.bind(Usuario::getCuil, Usuario::setCuil);
			 

			
		}
		
		//creamos variables validadores para el campo que necesitamos
		private Validator<String> validadorCuil = new Validator < String > ( ) {
            @Override
            public ValidationResult apply ( String str, ValueContext valueContext ) {
            	if(str.length() > 9 || str.length() == 0) {
            	   return  ValidationResult.ok () ;
               } else {
                  
                   return  ValidationResult.error ( "Debe contener al menos 10 digitos" );
               }
            }
        } ;
		
        private Validator<Integer> convertidoCuil = Validator.from ( value -> value >= 0, "Sea mayor o igual a cero." );
        
        private Validator<String> validadorPassword =  new Validator < String > ( ) {
        		@Override
                public ValidationResult apply ( String str, ValueContext valueContext ) {
        			if(str.equals(password.getValue())) {
                	   return  ValidationResult.ok () ;
                   } else {
                      
                       return  ValidationResult.error ( "No coinciden las passwords" );
                   }
                }
        };
        		

}
