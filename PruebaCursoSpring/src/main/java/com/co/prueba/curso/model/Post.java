package com.co.prueba.curso.model;

import java.util.Date;

public class Post {
private int id;
private String  descripciopn;
private String urlImg;
private Date fecha;
private String titulo;




public Post() {
}

public Post(int id, String descripciopn, String urlImg, Date fecha, String titulo) {
	super();
	this.id = id;
	this.descripciopn = descripciopn;
	this.urlImg = urlImg;
	this.fecha = fecha;
	this.titulo = titulo;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDescripciopn() {
	return descripciopn;
}
public void setDescripciopn(String descripciopn) {
	this.descripciopn = descripciopn;
}
public String getUrlImg() {
	return urlImg;
}
public void setUrlImg(String urlImg) {
	this.urlImg = urlImg;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}

}
