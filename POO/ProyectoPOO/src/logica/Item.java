package logica;

import java.util.ArrayList;

public class Item {
	private String nombre;
	private int codigo;
	private String descripcion;
	private Tipo tipo;
	private Prestamo prestamo;
	private ArrayList<Categoria> categorias;
	
	public Item(String nombre, ArrayList<Categoria> categorias, Tipo tipo, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categorias = categorias;
		this.tipo = tipo;
	}
	
	public void modificarItem(String nombre, ArrayList<Categoria> categorias, Tipo tipo, String descripcion) {
		this.nombre = nombre;
		this.categorias = categorias;
		this.tipo = tipo;
		this.descripcion = descripcion;
	}
	
	public String consultarItem() {
		return "Nombre del item: " + nombre +
				"\nCodigo del item: " + codigo + 
				"\nTipo de item: " + tipo +
				"\nCategorias a las que pertenece: " + categorias +
				"\n\n" + descripcion;
	}
	
	public void agregarAPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}
	
	public void setCategorias(ArrayList<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	public Tipo getTipo() {
		return tipo;
	}
	
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	public Prestamo getPrestamo() {
		return prestamo;
	}
	
	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

}
