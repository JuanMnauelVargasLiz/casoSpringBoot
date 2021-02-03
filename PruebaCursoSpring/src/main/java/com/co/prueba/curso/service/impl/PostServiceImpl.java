package com.co.prueba.curso.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.co.prueba.curso.model.Post;
import com.co.prueba.curso.service.PostService;

@Service("postServiceImpl")
public class PostServiceImpl implements PostService {
	private final Log log= LogFactory.getLog(getClass());

	
	public List<Post> validacionIdd(List<Post> lista) {
		log.info("Esta es la clase numero uno");
		for (Post post : lista) {
			if (post.getTitulo() == null) {
				throw new NullPointerException("el id viene vacio");
			}
		}
		return lista;
	}


}
