package com.ungs.espe2017.view.controller;
import javax.servlet.annotation.WebServlet;

//import com.ungs.espe2017.model.service.ServiciosUsuario;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.UI;
@Theme("mytheme")
public class MyUI extends UI {

	/**
	 * 
	 */
	//UID
	private static final long serialVersionUID = 1L;
	
	
	//Estructura
	private Navigator navegador ;
	
	//Vistas
	
	//Servicios
	//private ServiciosUsuario usuarioService = new ServiciosUsuario();
	
	@Override
	protected void init(VaadinRequest vaadinRequest) {
		String usernameFromSession = (String) VaadinSession.getCurrent().getAttribute("username");
		navegador = new Navigator(this, this);

		if (usernameFromSession != null) {
			navegador.addView(Inicio.NAME, new Inicio());
			navegador.navigateTo(Inicio.NAME);
		} else {
			navegador.addView(Login.NAME, new Login());
			navegador.navigateTo(Login.NAME);
			
		}
	}
	
	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	}

//
//
//	
//	private class DashboardView extends CustomComponent implements View {
//
//		/**
//		 * 
//		 */
//		private static final long serialVersionUID = 1L;
//
//		public DashboardView() {
//			setCompositionRoot(new VerticalLayout(
//					new Label("Hello " + (String) VaadinSession.getCurrent().getAttribute("username")),
//					new Button("Logout", e -> onLogoutClick())
//			));
//		}
//
//		private void onLogoutClick() {
//			getUI().getSession().getSession().invalidate();
//			String location = Page.getCurrent().getLocation().toString();
//			String loginPageUrl = location.substring(0, location.indexOf('#'));
//			getUI().getPage().setLocation(loginPageUrl);
//		}
//	}

}

