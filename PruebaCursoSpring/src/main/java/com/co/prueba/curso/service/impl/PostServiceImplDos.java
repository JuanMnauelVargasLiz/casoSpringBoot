package com.co.prueba.curso.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.co.prueba.curso.model.Post;

@Service("postServiceImplDos")
public class PostServiceImplDos {
	private final Log log= LogFactory.getLog(getClass());
	public List<Post> validacionIdd(List<Post> lista) {
		log.error("Esta es la clase numero 2");
		for (Post post : lista) {
			if (post.getId() == 0) {
				throw new NullPointerException("el id viene vacio");
			}
		}
		return lista;
	}
}
