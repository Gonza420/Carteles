package com.ungs.espe2017.model.service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ungs.espe2017.model.domain.Post;

public class ServiciosPost {
	
	/*static String[] posteosv = { "Voveraaaaaaaaaaaaaaaaaas volveraaaaaaaaaaaaas seguro que pronto vuelves a mi vida", 
		"I heard the passing bells calling out my name I knew I'd never see another day I couldn't swim against the tides of blame I knew there was no other way", 
		"You better practice your lines You better practice your words I know that real monsters lie Between the light and the shade It doesn't matter what you say or feel When honest men become deranged, they'll genuflect to a lie",
		"I saw the dagger eyes staring back at me I knew I'd never have a chance to plead Guilty, but in the sight of fallen men They bury you before you speak The sin and the sentence" };
	*/
	
	private static ServiciosPost instance;

	private Post post = new Post();
	 private HashMap<Long, Post> posteos = new HashMap<Long, Post>();
	 
	    public synchronized void save(Post entry) {
	        if (entry.getId() == null) {
	          entry.guardar(entry);
	        }
	    }
	    
		public synchronized List<Post> findAll() {
			
			List<Post> r = post.ObtenerTodos("from POST",(Class<Post>) post.getClass());
			return r;
		}
		
	
	    
	/* public synchronized  List<Post> findAll() throws CloneNotSupportedException {
	        ArrayList arrayList = new ArrayList();
	        for (Post post : posteos.values()) {
	
	                    arrayList.add(post.clone());
	                }

	        

	        return arrayList;
	    }*/
}
