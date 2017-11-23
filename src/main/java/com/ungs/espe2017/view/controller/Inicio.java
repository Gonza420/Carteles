package com.ungs.espe2017.view.controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.ungs.espe2017.model.domain.Post;
import com.ungs.espe2017.model.service.ServiciosPost;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Binder;
import com.vaadin.data.ValidationException;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
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
@Theme("mytheme")
public class Inicio extends UI {
	public static final String NAME = "Explora los post";
	private ServiciosPost inicio_postService = new ServiciosPost();
	Postear postear ;
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	postear = new Postear(inicio_postService);
       
    	buildLayout();
    	
    	
    	/* final VerticalLayout layout = new VerticalLayout();
        
        final TextField name = new TextField();
        name.setCaption("Type your name here:");

        Button button = new Button("Click Me");
        button.addClickListener(e -> {
            layout.addComponent(new Label("Thanks " + name.getValue() 
                    + ", it works!"));
        });
        
        layout.addComponents(name, button);
        
        setContent(layout);
        */
    	
    	
    }
    
		
	private void buildLayout() {
	 
        HorizontalLayout actions = new HorizontalLayout(postear);
        actions.setWidth("100%");
        postear.setWidth("100%");
        actions.setExpandRatio(postear, 1);

        VerticalLayout left = new VerticalLayout(actions, postear);
        left.setSizeFull();
        postear.setSizeFull();
        left.setExpandRatio(postear, 1);
        
        HorizontalLayout mainLayout = new HorizontalLayout(left);
        mainLayout.setSizeFull();
        mainLayout.setExpandRatio(left, 1);

        setContent(mainLayout);
	}
	
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
