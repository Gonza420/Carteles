package com.ungs.espe2017.model.service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ungs.espe2017.model.dao.IPostDAO;
import com.ungs.espe2017.model.domain.Post;

public class ServiciosPost {
	
	private IPostDAO dao = new IPostDAO();
	
	 
	    public synchronized void save(Post entry) {
	    	entry.setCalificacion(1);
	    	entry.setCantCal(1);
	    	dao.crear(entry);
	    }
	    
		public List<Post> findAll() {
			List<Post> myList = new ArrayList<Post>();
			myList = dao.todos();
			return myList;
		}
		public synchronized void guardarCal (double  c, Post post ) {
			post.setCalificacion(c);
			dao.actualizar(post);
		}
		
	    
	}
