package com.ungs.espe2017.view.controller;

import com.ungs.espe2017.model.domain.Post;
import com.ungs.espe2017.model.service.ServiciosPost;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.SingleSelect;
import com.vaadin.ui.Slider;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.ValoTheme;

public class CalificaForm extends FormLayout implements View {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Label label = new Label("Calificacion Actual");
	private Label label2 = new Label("A Calificar");
	private Button cal = new Button ("Califica!");
	private Button cancel = new Button ("Cancelar");
	private Slider sliderA = new Slider(1,5);
	private Slider slider = new Slider(1,5);
	
	ServiciosPost servicioPost = new ServiciosPost();
	Post post;
	
	public CalificaForm() {
		configureComponents();
		buildLayout();
	}

	private void configureComponents() {
		cal.setStyleName(ValoTheme.BUTTON_PRIMARY);
		cancel.setStyleName(ValoTheme.BUTTON_PRIMARY);
		setVisible(false);
		
	}

	private void buildLayout() {
        setSizeUndefined();
        setMargin(true);
        
        HorizontalLayout actions = new HorizontalLayout (cal,cancel);
        actions.setSpacing(true);
        addComponents(label,sliderA,label2,slider,actions);
        cal.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				int value = slider.getValue().intValue();
				servicioPost.guardarCal(value,post);
				setVisible(false);
				
			}
		});
		cancel.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				setVisible(false);
				
			}
		});
	}
	
    void edit(SingleSelect<Post> selection) {
        this.post = selection.getValue();
        sliderA.setValue(post.getCalificacion());
        slider.setValue((double) 1);
        setVisible(true);
    }
    @Override
    public MyUI getUI() {
        return (MyUI) super.getUI();
    }
}
