package logica;

import java.util.ArrayList;

public class Tipo {
	private String nombre;
	private ArrayList<Item> items;
	
	public Tipo(String nombre) {
		this.nombre = nombre;
	}
	
	public void modificarTipo(String nombre) {
		this.nombre = nombre;
	}
	
	public String consultarTipo() {
		return "Nombre del tipo: " + nombre +
				"\nItems de este tipo: " + items;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}
	
	public void agregarItem(Item item) {
		items.add(item);
	}
	
	public void eliminarItem(Item item) {
		items.remove(item);
	}
}
