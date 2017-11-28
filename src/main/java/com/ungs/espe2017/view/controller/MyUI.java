package com.ungs.espe2017.view.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.annotation.WebServlet;

import com.ungs.espe2017.model.domain.Post;
import com.ungs.espe2017.model.service.ServiciosPost;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Binder;
import com.vaadin.data.ValidationException;
import com.vaadin.event.ShortcutAction;
import com.vaadin.event.selection.SelectionEvent;
import com.vaadin.event.selection.SelectionListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.SingleSelect;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;


/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@SuppressWarnings("unchecked")
@Theme("mytheme")
public class MyUI extends UI {
	Button postear = new Button("Postea!");
	TextField entrada = new TextField();
	Grid<Post> posteos = new Grid<>();
	
	CalificaForm calificaForm = new CalificaForm();
	ServiciosPost servicio = new ServiciosPost();
	Binder<Post> binder = new Binder<>(Post.class);
	
	
	Post nuevoPost;
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
       
    	configureComponents();
    	buildLayout();
    	
    	
    	
    }
    
	private void configureComponents() {
	
        postear.addClickListener(new ClickListener() {


			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
					try {
						bindearNuevo();
					} catch (ValidationException e) {
						e.printStackTrace();
					}

				
			}
        });

	   
		
		List<Post> poste = servicio.findAll();
        posteos.setItems(poste);
        posteos.addColumn(Post::getContenido).setCaption("Posts");
       postear.setStyleName(ValoTheme.BUTTON_PRIMARY);
       postear.setClickShortcut(ShortcutAction.KeyCode.ENTER);
       posteos.setSelectionMode(Grid.SelectionMode.SINGLE);
       posteos.addSelectionListener(event -> {
    	   SingleSelect<Post> selection = posteos.asSingleSelect();
    	   calificaForm.edit(selection);
       });
	}
	private void buildLayout() {
	 
        HorizontalLayout actions = new HorizontalLayout(entrada, postear);
        actions.setWidth("100%");
        entrada.setWidth("100%");
        actions.setExpandRatio(entrada, 1);

        VerticalLayout left = new VerticalLayout(actions, posteos);
        left.setSizeFull();
        posteos.setSizeFull();
        left.setExpandRatio(posteos, 1);
        
        HorizontalLayout mainLayout = new HorizontalLayout(left, calificaForm);
        mainLayout.setSizeFull();
        mainLayout.setExpandRatio(left, 1);

        setContent(mainLayout);
	}
	
	
	   public void refreshContenido() {
		   List<Post> poste = servicio.findAll(); 
		   posteos.setItems(poste);
		   calificaForm.setVisible(false);
	        
	    }
	   
	   private void bindearNuevo() throws ValidationException{
		   binder.bind(entrada, Post::getContenido, Post::setContenido);
		   nuevoPost = new Post();
		   nuevoPost.setContenido(entrada.getValue());
		   binder.setBean(nuevoPost);
		   if(nuevoPost != null)
		   servicio.save(nuevoPost);
		   refreshContenido();
	   }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
