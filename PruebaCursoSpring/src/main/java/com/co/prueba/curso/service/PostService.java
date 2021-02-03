package com.co.prueba.curso.service;

import java.util.List;

import com.co.prueba.curso.model.Post;

public interface PostService  {

	public List<Post> validacionIdd( List<Post>lista) throws NullPointerException;
}
