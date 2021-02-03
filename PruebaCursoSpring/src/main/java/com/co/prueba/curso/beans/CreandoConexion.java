package com.co.prueba.curso.beans;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.co.prueba.curso.model.Conexion;
import com.co.prueba.curso.model.Usuario;

@Component
public class CreandoConexion {
	@Bean(name = "beanUsuario")
	public Usuario getUsuario() {
		return new Usuario();
	}
	
	
	@Bean(name = "beanConexion")
	public Conexion getConexion() {
		Conexion conexion= new Conexion();
		conexion.setDb("postgres");
		conexion.setUrl("localhost");
		return conexion;
	}
	
	public DataSource getDataSource() {
		DriverManagerDataSource datasource= new DriverManagerDataSource();
		datasource.setDriverClassName("");
		datasource.setUrl("");
		datasource.setUsername("postgres");
		datasource.setPassword("12345");
		return datasource;
	}

}
