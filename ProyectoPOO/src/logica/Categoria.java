package logica;

import java.util.ArrayList;

public class Categoria {
	private String nombre;
	private ArrayList<Item> items;
	
	public Categoria(String nombre) {
		this.nombre = nombre;
		items = new ArrayList<>();
	}
	
	public void modificarCategoria(String nombre) {
		this.nombre = nombre;
	}
	
	public String consultarCategoria() {
		return "Nombre de la categoria: " + nombre +
				"Items que pertenecen a la categoria: " + items;
	}
	
	public void agregarItemALaCategoria(Item item) {
		items.add(item);
	}
	
	public void borrarItemDeLaCategoria(Item item) {
		items.remove(item);
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
	
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
}
