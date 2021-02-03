package com.co.prueba.curso.componentes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.co.prueba.curso.model.Post;

@Component("postComponent")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON) //,proxyMode =ScopedProxyMode.TARGET_CLASS )
public class PostComponent {

	
	public List<Post> getPostLista() {
		ArrayList<Post> post = new ArrayList<>();
		post.add(new Post(1, "descripcion mensaje", "rut imagen", new Date(), "titulo imagen"));
		post.add(new Post(2, "descripcion mensaje", "rut imagen", new Date(), "titulo imagen"));
		post.add(new Post(3, "descripcion mensaje", "rut imagen", new Date(), "titulo imagen"));
		post.add(new Post(4, "descripcion mensaje", "rut imagen", new Date(), "titulo imagen"));
		return post;
	}
}
