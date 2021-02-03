package com.co.prueba.curso.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.co.prueba.curso.model.Post;

@Service("postServiceDecoracionImpl")
@Scope("singleton")
public class PostServiceDecoracionImpl {
	private final Log log= LogFactory.getLog(getClass());
	@Autowired
	private PostServiceImpl postServiceImpl;
	
	@Autowired
	private PostServiceImplDos postServiceImplDos;
	
	
	public List<Post> validacionIdd(List<Post> lista) throws NullPointerException{
		log.debug(lista);
		lista= postServiceImpl.validacionIdd(lista);
		lista= postServiceImplDos.validacionIdd(lista);
		for (Post post : lista) {
			if (post.getDescripciopn() == null) {
				throw new NullPointerException("la descripcion viene vacia");
			}
			if (post.getFecha() == null) {
				throw new NullPointerException("la fecha viene vacia");
			}
		}
		log.info("Esta es la clase decorada");
		return lista;
	}

	
}
