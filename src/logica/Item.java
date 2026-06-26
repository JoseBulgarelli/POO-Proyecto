package logica;

import java.io.Serializable;
import java.util.ArrayList;

public class Item implements Serializable {
	private String nombre;
	private int codigo;
	private String descripcion;
	private Tipo tipo;
	private Prestamo prestamo;
	private ArrayList<Categoria> categorias;
	
	public Item(String nombre, Tipo tipo, String descripcion, int codigo) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.codigo = codigo;
		prestamo = null;
		categorias = new ArrayList<>();
	}
	
	public void modificarItem(String nombre, Tipo tipo, String descripcion) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.descripcion = descripcion;  // No tengo muy claro esto, deberia verlo con la interfaz
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
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

}
