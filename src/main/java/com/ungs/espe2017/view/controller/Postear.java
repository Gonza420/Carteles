package com.ungs.espe2017.view.controller;

import java.util.List;

import com.ungs.espe2017.model.domain.Post;
import com.ungs.espe2017.model.service.ServiciosPost;
import com.vaadin.data.Binder;
import com.vaadin.data.ValidationException;
import com.vaadin.event.ShortcutAction;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.SingleSelect;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.ValoTheme;

public class Postear extends VerticalLayout implements View  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String NAME = "Postear";
	private Button postear = new Button("Postea!");
	private TextField entrada = new TextField();
	private Grid<Post> posteos = new Grid<>();
	
	private CalificaForm calificaForm = new CalificaForm();
	private ServiciosPost servicio = new ServiciosPost();
	private Binder<Post> binder = new Binder<>(Post.class);
	
	
	private Post nuevoPost;
	
    protected Postear() {
       
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
        
        addComponent(mainLayout);
//        getUI().getNavigator().addView("menu_calificacion", calificaForm);
//        getUI().getNavigator().navigateTo("menu_calificacion");
        
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


}
