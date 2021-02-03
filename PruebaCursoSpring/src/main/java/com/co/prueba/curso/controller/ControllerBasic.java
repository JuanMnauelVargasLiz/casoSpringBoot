package com.co.prueba.curso.controller;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.co.prueba.curso.componentes.PostComponent;
import com.co.prueba.curso.model.Post;
import configuration.Paginas;

@Controller
@RequestMapping(path = "/home")
public class ControllerBasic {
	@Autowired
	private PostComponent postComponent; // llevamos la lista a un beans de componente para poder llamarlo

	@GetMapping(path = { "/saludar", "/holamundo" })
	public String saludar(Model model) {
		model.addAttribute("posts", this.postComponent.getPostLista());
		return "index";
	}

	@GetMapping(path = "/posts")
	public ModelAndView postVista() { // ModelAndView en el modelo me carga la lista y me pide a que vista seria
										// enviada como lo vemos en el ejemplo
		ModelAndView modelAndView = new ModelAndView(Paginas.HOMES);
		modelAndView.addObject("posts", this.postComponent.getPostLista());
		return modelAndView;
	}

	// crear un pos individual mediante un lambar
	@GetMapping(path = "/post")
	public ModelAndView getPostIndividual(@RequestParam(defaultValue = "1", name = "id", required = false) int id) {
		ModelAndView modelAndView = new ModelAndView(Paginas.POST);
		List<Post> posFiltrado = this.postComponent.getPostLista().stream().filter((post) -> {//stream:string de datos--filter:filtrar nos pide una expsion lambar--collect:recolectar todo--Collectors.toList():convertir a un arraylist 
			return post.getId() == id;
		}).collect(Collectors.toList());
		modelAndView.addObject("post", posFiltrado.get(0));
		return modelAndView;
	}
	
	// crear un pos individual mediante un lambar y @PathVariable: que sirve para asignarle un valor a la url.
	@GetMapping(path = "/post/p/{post1}")
	public ModelAndView getPostIndividual1(@PathVariable(required = true, name = "post1") int id) {
		ModelAndView modelAndView = new ModelAndView(Paginas.POST);
		List<Post> posFiltrado = this.postComponent.getPostLista().stream().filter((post) -> {//stream:string de datos--filter:filtrar nos pide una expsion lambar--collect:recolectar todo--Collectors.toList():convertir a un arraylist 
			return post.getId() == id;
		}).collect(Collectors.toList());
		modelAndView.addObject("post", posFiltrado.get(0));
		return modelAndView;
	}
	
	@GetMapping("/postNew")
	public ModelAndView getForm() {
		return new  ModelAndView("form").addObject("postObject",new Post());
	}
	
	@PostMapping("/addNewPost")
	public String addNewPost(Post postObject, Model model ) {
		List<Post>listaPosts=this.postComponent.getPostLista();
		listaPosts.add(postObject);
		model.addAttribute("posts", listaPosts);
		return "index";
}
}
