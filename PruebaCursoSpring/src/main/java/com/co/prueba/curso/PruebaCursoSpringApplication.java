package com.co.prueba.curso;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.co.prueba.curso.componentes.PostComponent;
import com.co.prueba.curso.model.Conexion;
import com.co.prueba.curso.service.PostService;

@SpringBootApplication
public class PruebaCursoSpringApplication implements CommandLineRunner{
	@Autowired  // validar que es un beans
	@Qualifier("beanConexion")  // cual es el beans que se tomo para eso se tiene el nombre
	private Conexion conexion;
	
	@Autowired
	@Qualifier("postComponent")
	private PostComponent component;
	
	@Autowired
	@Qualifier("postServiceImpl")
	public PostService postService;
	
	@Autowired
	@Qualifier("postServiceDecoracionImpl")// usamos el llamado de dos clases pero decorasdos en una sola clase
	public PostService postServiceDecoracion;
	
	public static void main(String[] args) {
		SpringApplication.run(PruebaCursoSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Log log= LogFactory.getLog(PruebaCursoSpringApplication.class);
//	System.out.println(conexion.getDb());

//		component.getPostLista().forEach((post) ->{
//		System.out.println(post.getDescripciopn());	
//		});
	
//		postService.validacionIdd(component.getPostLista()).
//					forEach((post)->{
//		System.out.println(post.getTitulo());			
//					});
	
		try {
			postServiceDecoracion.validacionIdd(component.getPostLista()).
			forEach((post)->{
				log.info(post.getTitulo());			
			});	
		} catch (Exception e) {
				log.error(e.getMessage());
		}

		
	}

}
